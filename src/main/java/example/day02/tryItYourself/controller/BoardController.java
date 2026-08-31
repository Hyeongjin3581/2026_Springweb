package example.day02.tryItYourself.controller;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import example.day02.tryItYourself.model.dao.BoardDao;
import example.day02.tryItYourself.model.dto.BoardDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
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

    // [4] 개별삭제 Controller
    @DeleteMapping("/board/delete")
    public boolean delete(@RequestParam("phone")String phone ){
        return bd.delete( phone );
    }

}   // class end
