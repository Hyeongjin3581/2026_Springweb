package example.Practice5_2.Controller;

import example.Practice5_2.Service.CommentService;
import example.Practice5_2.Model.Dto.CommentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/board/comments")
public class CommentController {
    // 의존성주입 (Service)
    @Autowired private CommentService commentService;

    // 1. 댓글 등록 기능
    @PostMapping ("")
    public boolean 댓글등록(@RequestBody CommentDto commentDto){
        return commentService.댓글등록(commentDto);
    }

    // 2. 댓글 삭제 기능
    @DeleteMapping ("")
    public boolean 댓글삭제(
        @RequestParam(name="commentId") Integer commentId,
        @RequestParam(name="password") String password){
            return commentService.댓글삭제(commentId , password);
        }
}
