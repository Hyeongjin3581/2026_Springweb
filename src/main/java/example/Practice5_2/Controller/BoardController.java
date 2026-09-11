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
    // 의존성주입 (Service)
    @Autowired private BoardService boardService;

    // 1. 게시글 등록기능
    @PostMapping ("")
    public boolean 등록기능(@RequestBody  BoardDto boardDto){
        return boardService.등록기능(boardDto);
    }

    // 2. 목록 조회 기능
    @GetMapping ("")
    public List<BoardDto>전체조회(){
        return boardService.전체조회();
    }
    // 3. 게시글 삭제 기능
    @DeleteMapping ("")
    public boolean 삭제기능(
        @RequestParam(name="id") Integer id,
        @RequestParam(name="password") String password ){
            return boardService.삭제기능(id , password);
        }
}

