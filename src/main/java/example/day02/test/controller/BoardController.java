package example.day02.test.controller;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import example.day02.test.model.dao.BoardDao;
import example.day02.test.model.dto.BoardDto;

import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;





/*
    컨트롤러에 서블릿(HTTP 프로토콜 사용 가능하게 기능/방법(GET / POST / PUT / DELETE) 을 제공하는 클래스 (HTTPServlet에 상속받음.))기능 달기
    * 레거시(과거) 코드는 상속받아 서블릿 구현

    * 스프링은 @Controller 포함. 
    * 반환타입이 JSON이면 @RestController를 사용 
    
    //1.  웹 기술을 포함한 컨트롤러 클래스 위에 @Controller 입력. // 스프링의 어노테이션 or 앱 or 웹 or 레거시를 면접 때 질문받을 수 있음. 
        * HTTP content type : http 전송 데이터 타입 명시.(데이터유형별 타입 명시.)
        * text/html , application / json , form 등등    / DTO(java) 라서 DTO반환은 없다.  
    //2. 해당 메소드마다의 url 정의
        * URL 정의시 http://127.0.0.1:8080(도메인) 이후 경로(path/url) 정의 , 중복없이 아무거나.
        1.PostMapping("/URL") : HTTP 메소드중 POST
*/



@RestController // Spring에서는 서블릿을 상속이 아닌 @Controller 어노테이션으로 지원(HTTP 사용.) + 반환타입이 json이면 @RestController (HTTP content-type자동으로 application/json 세팅)
public class BoardController {
    private BoardDao bd = BoardDao.getInstance();
    // [1] 등록
    @PostMapping( "/board/save" )
    public boolean save( BoardDto boardDto ){
        boolean result = bd.save(boardDto);
        return result;
    }
    // [2] 전체조회
    @GetMapping("/board/findall")
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
    // [3] 개별수정 Controller 
    @PutMapping("/board/update")
    public boolean update( BoardDto boardDto ){
        return bd.update( boardDto );
    }

    //[4] 개별삭제
    @DeleteMapping("/board/delete")
    public boolean delete(@RequestParam("no") int no){
        return bd.delete(no);
    }
} // class end 