package example.Practice5.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice5.Model.Dto.BoardDto;
import example.Practice5.Model.Dto.CommentDto;
import example.Practice5.Model.Entity.BoardEntity;
import example.Practice5.Model.Repository.BoardRepository;


@Service 
public class BoardService { 
    @Autowired private BoardRepository boardRepository;

    // 1. 게시글 등록
    public boolean 게시글등록(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        if(savedEntity.getId()>=1){return true;}
        return false;
    }

    // 2. 게시글 전체조회
    public List<BoardDto> 전체조회(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach((boardEntity) -> {
            BoardDto boardDto = BoardDto.from(boardEntity);
            boardEntity.getCommentEntities().forEach((commentEntity)->{
                CommentDto commentDto = CommentDto.from(commentEntity);
                boardDto.getComments().add(commentDto);
            });
            boardDtos.add(boardDto);
        });
        return boardDtos;
    }

    // 3. 게시글 삭제
    public boolean 게시글삭제(Integer id , String password){
        BoardEntity boardEntity = boardRepository.findById(id).orElse(null);
        if(boardEntity != null){
            if(boardEntity.getPassword().equals(password)){
                boardRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }
}