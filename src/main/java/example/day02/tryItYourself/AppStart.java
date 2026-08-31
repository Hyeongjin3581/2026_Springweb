package example.day02.tryItYourself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링은 프레임워크로 다양한 도구와 틀을 제공. 
// 사실상 라이브러리 천국이라 틀에 맞추어 라이브러리를 잘 활용하는것이 관건. 
// @어노테이션: 코드의 추가적인 설명과 의미를 부여할 때 사용(라벨/주석)
/* 1. @SpringBootApplication : 
        1) 내장 톰캣 (자동)세팅
        2) 서블릿(Controller/컴포넌트(조각단위 얘기할 때 사용.)) 자동 등록
*/

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
    // 2. spring 실행 , SpringBootApplication [x] SpringApplication [o]
    // SpringApplication.run(현재클래스명.class); 
    // 현재 클래스의 메타정보(멤버변수  / 생성자 /  메소드) 반환. 
    // --> SpringApplication.run(springboot 정보)를 가짐.  
    SpringApplication.run(AppStart.class);
    // 3. ctrl + F5실행 , 주의할 점: 2개 이상 실행 불가능
    // 4. 실행 확인 : http://127.0.0.1:8080




    }   // main end
} // class end
