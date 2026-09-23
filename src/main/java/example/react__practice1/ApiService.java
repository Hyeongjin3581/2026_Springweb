package example.react__practice1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service 
public class ApiService {


    @Value ("${api.public.data.service-Key2}")
    private  String serviceKey2;

    //[1].  정형진 살고싶은우리동네카테고리
    public Map<String, Object> testJin(){
        // 1. API 주소 (공공데이터 신청한 api 요청 url)
        String url = "https://api.odcloud.kr/api/15144308/v1/uddi:6b4313c0-ceef-428f-b56f-e8d3337b2395";
        url += "?page=" + 1;
        url += "&perPage=" + 10;
        url += "&serviceKey=" + serviceKey2;
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
}