package example.Practice5_2.Controller;

import example.Practice5_2.Service.BoardService;
import example.Practice5_2.Model.Dto.BoardDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/api/board")
public class BoardController {
    @Autowired private BoardService boardService;

    // 1. 게시글 등록 기능
    @PostMapping ("")
    public boolean 게시물등록(@RequestBody BoardDto boardDto){
        return boardService.게시글등록(boardDto);
    }
    // 2. 목록조회
    @GetMapping ("")
    public List<BoardDto>게시글전체조회(){
        return boardService.게시글전체조회();
    }

    //3. 게시글 삭제
    @DeleteMapping("")
    public boolean 게시글삭제(
        @RequestParam (name ="id")Integer id,
        @RequestParam (name = "password")String password){
            return boardService.게시글삭제(id , password);
        }

}
