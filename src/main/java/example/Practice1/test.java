package example.Practice1;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/test")
public class test {

    @PostMapping //1
    public boolean testWrite( @RequestBody TestDto testDto ){
        return true;
    }

    @GetMapping  //2
    public ArrayList<TestDto>testPrint(){
        System.out.println("TestController.testPrint()");
        ArrayList<TestDto> list = new ArrayList<>();
        list.add(new TestDto(1, "내용", "유재석"));
        list.add(new TestDto(2, "내용2", "강호동"));
        return list;
    }

    //@GetMapping은 9번과 11번을 주로 사용한다.
    //@RequestParam / @PathVariable
    @GetMapping("/detail") // public 반환타입 함수명(@어노테이션(name ="?")매개변수 타입)
    public TestDto testDetail(@RequestParam (name ="no") int no ){
        System.out.println("TestController.testPrint()");
        return new TestDto(1, "내용1","작성자1");
    }

    @DeleteMapping("/{no}")
    public boolean testDelete(@PathVariable(name = "no")int no){
        System.out.println("TestController.testPrint()");
        return true;
    }

    @PutMapping("")
    public boolean testUpdate(@RequestBody TestDto testDto){
        System.out.println("TestController.testPrint()");
        return true;
    }

} // class end

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor  // @NoArgsConstructor .// @Builder
class TestDto{
    private int no;
    private String content;
    private String writer;

}

/*
    int : 기본타입 +-21억
    Integer : 참조타입(int의 래퍼클래스) + null(없다 뜻) 저장
*/