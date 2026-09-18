package example.day08;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


@Service 
public class ApiService {

    // 서비스키 안전하게 application.properties 에서 관리, 즉] 프로젝트간 api키는 github push 하지말자!, notion/excel 에서 공유
    // @Value("${application.propertis속성명}")

    @Value ("${api.public.data.service-Key}")
    private  String serviceKey;

   @Value ("${api.public.data.service-Key2}")
   private  String serviceKey2;

    //[1]. 
    public Map<String, Object> test1(){
        // 1. API 주소 (공공데이터 신청한 api 요청 url)
        String url = "https://api.odcloud.kr/api/15052602/v1/uddi:855807e2-fe8a-4e47-8a5a-ce1894e410d7_201909031553";
        url += "?page=" + 1;
        url += "&perPage=" + 20;
        url += "&serviceKey=" + serviceKey;
        // 2. WebClient 객체 빌더패턴 생성
        WebClient webClient = WebClient.builder().build();
        //3. WebClient 객체 이용한 api 요청하고 응답받기
        Map<String,Object> response = webClient.get() // .http 메소드명 , http.GET메소드
                        .uri( url )   // url은 http 주소상에 지원(쿼리스트링) 까지 포함
                        .retrieve() // 요청 결과 반환 결과 수신
                        .bodyToMono(Map.class) // 응답 결과 content-type
                        .block(); // 동기화
                        return response;
    }

    // [2] 국립중앙의료원_전국 약국 정보 조회 서비스
 
    public Map<String, Object> test2(){

    String url = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";

    url += "?serviceKey=" + serviceKey2;
    url += "&pageNo=" + 1;
    url += "&numOfRows=" + 30;

    WebClient webClient = WebClient.builder().build();

    // 3. 주의할점 : webClient 에서 xml 타입을 String 타입으로 가져오기
    String response = webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(String.class) // XML 타입--> String
            .block();
    //4. String -> xml 변환, 
    XmlMapper xmlMapper = new XmlMapper(); // xmlMapper 객체 생성
    try{
        Map<String,Object> map =xmlMapper.readValue( response,Map.class);
        return map;
        } catch( Exception e ) {System.out.println(e); }
        return null;
    }

    // [3] 프로젝트내 resources -> static -> 파일명.csv
    public List<Map<String , Object>> test3(){
        // 1. csv파일 경로 ,resources 이하 폴더 
        String fileName = "static/중소벤처기업부_벤처기업명단_20260521.csv";
        // 2. ClassPathResource 객체 이용하여 해당 경로내 파일 가져오기 [파일객체]
        ClassPathResource resource = new ClassPathResource(fileName);
        List<Map<String,Object>> list = new ArrayList<>();
        try{
            // 3. (대용량)파일들을 바이트로 읽어와서 바이트 배열에 저장 .getInputStream().readAllBytes();
            byte[] bytes = resource.getInputStream().readAllBytes();
            // 4. 한글 인코딩 , EUC-KR , CP949 , UTF-8
            InputStreamReader reader = new InputStreamReader(new java.io.ByteArrayInputStream(bytes) , Charset.forName("UTF-8"));

           // 5. OpenCSV 이용하여 바이트들을 대입한다.
           CSVReader csvReader = new CSVReaderBuilder(reader).build(); 

           //6. 주로 첫행은 제목(행) 가져오기 ( Key/속성명 사용할 예정 )

           String[] headers = csvReader.readNext(); // 한줄 읽어오기

           //7. 나머지 행들은 반복문 이용하여 가져오기
           String[] values;

           int count = 0;
           
           while( true ){   // 무한루프

                // 8.
                values = csvReader.readNext(); // 한줄 읽어오기
                if( values == null ) break; // 만약에 읽어온 데이터가 없으면 반복문 종료

                // 9. 반복문 이용하여 map 만들기
                Map<String, Object> row = new LinkedHashMap<>();

                for(int index = 0 ; index < headers.length ; index++){
                    row.put(headers[index] , values[index]);
                }
                // 10 . list에 생성한 map 추가
                list.add( row );

                // 11. Talend API 에서 출력 되는지 확인용 100개만 출력
                count++;
                if(count >= 100) break;
            }
        }catch(Exception e){System.out.println(e);}

        return list;
    }
    
}

/*
        JSON VS XML VS CSV

        - JSON(자바스크립트객체) : { 속성명 : 속성값 , 속성명 : 속성명 }
        - XML(마크업) : <속성명>속성값</속성명>         implementation 'com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.22.2'
        - CSV(,쉼표구분) : 값,값,값,값,값               implementation 'com.opencsv:opencsv:5.12.0'

    컬렉션프레임워크: List , Set , Map
        - List: 여러개 자료들을 인덱스로 구분하여 하나의 자료에 저장 
            -> [ 값1, 값2, 값3 ]
        - Set : 여러개 자료들을 인덱스(중복값)없이 하나의 자료에 저장 
            -> ( 값1, 값2, 값3 )
        - Map : key와value 한쌍(entry)으로 여러쌍을 하나의 자료에 저장
            -> { 속성명:값1 , 속성명:값2, 속성명:값3 }
    WebClient 객체 : 스프링에서 외부 API 요청 라이브러리 
        1.설치: implementation 'org.springframework.boot:spring-boot-starter-webflux' 
        2.객체: WebClient webClient = WebClient.builder().build();
    클래스명.class: 리플렉션( 특정/해당 클래스정보 반환 ) 
*/