package example.day03;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
// Spring MVC Controller 등록
// 반환값을 HTTP Response Body로 전달
public class RestConntroller1 {

    // GET 방식의 "/day03/task1" 요청과 task1() 연결
    @GetMapping("/day03/task1")
    public int task1(){

        System.out.println("RestConntroller1.task1()");
        return 10;
    }
    @GetMapping("/day03/task2")
    public String task2( ){
        System.out.println("RestController1.task2()");
        return " 안녕하세요";  // Content-Type: text/plain
    }
    // 3. 
    @GetMapping("/day03/task3")
    @ResponseBody
    public Map<String,Object> task3(){  // map 컬렉션 프레임워크 [ {key : value} , {key : value} ]
        Map<String , Object> map = new HashMap();
        map.put("유재석",100);
        map.put("강호동",90);
        return map; // Content-Type:    application /json
    }
    // 4. Dto
    @GetMapping("/day03/task4")
    @ResponseBody
    public ExamDto task4(){
        ExamDto dto = new ExamDto();
        dto.setName("유재석"); dto.setAge(50);
        return dto;
    }

}
//dto
@Data // Loombok
class ExamDto{ 
    String name; 
    int age;
}
/*
    @ResponseBody 란? 자바의 타입 --> HTTP content-type 반환하여 동일하게 사용/직렬화
    - String : text/plain;
    - 그외 : application/json 
*/