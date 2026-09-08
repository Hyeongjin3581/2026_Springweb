package example.Practice5.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice5.Model.Dto.CommentDto;
import example.Practice5.Model.Entity.BoardEntity;
import example.Practice5.Model.Entity.CommentEntity;
import example.Practice5.Model.Repository.BoardRepository;
import example.Practice5.Model.Repository.CommentRepository;

@Service 
public class CommentService { 
    @Autowired private CommentRepository commentRepository;
    @Autowired  private BoardRepository boardRepository;

    //1. 댓글 등록
    public boolean 댓글등록(CommentDto commentDto){
        CommentEntity commentEntity = commentDto.toEntity();
        BoardEntity boardEntity = boardRepository.findById(commentDto.getBoardId()).orElse(null);
        commentEntity.setBoardEntity(boardEntity);
        CommentEntity savedEntity = commentRepository.save(commentEntity);
        if(savedEntity.getCommentId()>=1){return true;}
        return false;
    }

    // 2. 댓글 삭제
    public boolean 댓글삭제(Integer commentId , String password){
        CommentEntity commentEntity = commentRepository.findById(commentId).orElse(null);
        if(commentEntity != null){
            if(commentEntity.getPassword().equals(password)){
                commentRepository.deleteById(commentId);
                return true;
            }
        }
        return false;
    }
}

