package example.Practice2;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {
    // 서비스 객체 불러오기
    private final TestService TestService;


    // [1] 저장
    @PostMapping("/day04/test")
    public boolean testWrite(@RequestBody TestEntity entity){
        return TestService.testWrite(entity);
    }
    // [2] 전체조회
    @GetMapping("/day04/test")
    public List<TestEntity>testPrint(){
        List<TestEntity> testServices = TestService.testPrint();
            return  testServices;
    }

    // [3] 게시물 개별조회
    @GetMapping("/day04/test/detail")
    public TestEntity testDetail(@RequestParam(name="no")int no){
        return TestService.testDetail(no);
    }

    //[4] 게시물 삭제
    @DeleteMapping("/day04/test")
    public boolean testDelete(@RequestParam(name ="no")int no){
        return TestService.testDelete(no);
    }
    //[5] 게시물 수정
    @PutMapping("/day04/test")
    public boolean testUpdate(@RequestBody TestEntity entity){
        return TestService.testUpdate(entity);
    }
}

