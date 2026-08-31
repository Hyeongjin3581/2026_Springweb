package example.day03;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


// @Component // 1. 스프링 컨테이너에 객체(빈) 등록
// @Controller // 2. HTTP 서블릿 지원 + @Component 포함
@RestController // 3. 응답 content - type을 'application/json' 설정(@ResponsBody) + @Controller
// **** 활용 : HTML(View) - > @Controller , Json(값) -> @RestController  **** 

@RequestMapping("/day03") // " 클래스내 메소드들의 공통URL 정의"
public class RestController2 { 

    @GetMapping("/task5") // 중복없는 URL 정의
    public String task5(){ return "서버에서 응답하는 메시지";}  // http://localhost:8080/day03/task5
    // ------------------------ 요청 매개변수 --------------------------- // 
    // 2.
    @GetMapping("/task6") // 클래스내 동일한 URL에 대해서는  @RequestMapping 해서 정의한다.
    public int task6( @RequestParam String name, @RequestParam int age){
        System.out.println(name); System.out.println(age);
        return 6;
    }
    // 3.
    @GetMapping("/task7") // 클래스내 동일한 URL에 대해서는  @RequestMapping 해서 정의한다.
    public int task7( 
    @RequestParam(name = "name") String name, 
    @RequestParam(name = "age") int age,
    @RequestParam(name = "count", defaultValue = "10") int count// @RequestParam(required = "필수여부" , defalutValue ="기본값")
    ){
        System.out.println(name); System.out.println( age ); System.out.println( count );
        return 7;
    }
    // 4. http://localhost:8080/day03/task8?name=유재석&age=10
    @DeleteMapping("/task8")
    public int task8(@RequestParam Map<String,Object> map){
        System.out.println(map);
        return 8;
    }
    // DTO는 멤버변수가 미리 정의되어 있어서 받을 데이터의 구조가 명확하지만, 
    // Map은 어떤 key-value가 들어올지 구조가 정해져 있지 않다. 따라서 @RequestParam을 붙여서 
    // "HTTP 요청 파라미터들을 이 Map에 담아달라"고 Spring에게 알려준다.
    
    //5. http://localhost:8080/day03/task9?name=유재석&age=10
    @DeleteMapping("/task9")
    public int task9(@ModelAttribute ExamDto examDto){
        System.out.println(examDto);
        return 9;
    }

    //6. 
    @GetMapping("/task10/{name}/{age}")
    public int task10(
        @PathVariable(name = "name") String name,
        @PathVariable(name = "age")  int age){
        System.out.println(name); System.out.println(age);
        return 10;
    }
    // 7.
    @PostMapping("/task11") // {"name" : "유재석" , "age" : 10 }
    public int task11(@RequestBody ExamDto examDto){
        System.out.println(examDto);
        return 11;
    }
}
    

