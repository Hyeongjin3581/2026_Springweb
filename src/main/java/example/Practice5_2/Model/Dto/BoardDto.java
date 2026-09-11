package example.Practice5_2.Model.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import example.Practice5_2.Model.Entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class BoardDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // boardDto에서 추후에 댓글 목록이 함께 포함되어야 함.
    @Builder.Default
    public List<CommentDto> comments = new ArrayList<>();

    // Dto에서 Entity로 변환.
    public BoardEntity toEntity(){
        return BoardEntity.builder()
        .author(this.author)
        .password(this.password)
        .content(this.content)
        .build();
    }
    // 1. 생성자에 매개변수대입여부. 

    // Entity 를 Dto로 변경 
    // 접근제어자 / 고정..? / 반환타입 / 메소드명 / 매개타입 / 매개변수
    public static BoardDto from(BoardEntity entity){
        return BoardDto.builder()
        .id(entity.getId())
        .author(entity.getAuthor())
        .password(entity.getPassword())
        .content(entity.getContent())
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
    }
}
