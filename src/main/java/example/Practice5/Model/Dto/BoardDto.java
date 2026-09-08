package example.Practice5.Model.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.Practice5.Model.Entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder 
@Data 
// 즉 , DTO 역할은 엔티티 자료들을 프론트엔드에 전달. ㅇㅇ
// + 추가적인 자료들을 무엇을 주고 받을지 RESTAPI
public class BoardDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    private  LocalDateTime createdAt;
    private  LocalDateTime upDatedAt;

   public BoardEntity toEntity(){
    return BoardEntity.builder()
    .author(this.author)
    .password(this.password)
    .content(this.content)
    .build();
    }
    // 2번 . 게시글 목록 조회 기능에서 댓글 목록까지 함께 조회하기위해서 사용.
    @Builder.Default
    private List<CommentDto> comments = new ArrayList<>();

    public static BoardDto from(BoardEntity entity){
        return BoardDto.builder()
        .id(entity.getId())
        .author(entity.getAuthor())
        .password(entity.getPassword())
        .content(entity.getContent())
        .createdAt(entity.getCreatedAt())
        .upDatedAt(entity.getUpdatedAt())
        .build();
    }
}
