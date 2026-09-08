package example.Practice5_2.Model.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.Practice5_2.Model.Entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Builder 
@Data 
public class BoardDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 추후 comments를 Get 하기 위해 사용.
    @Builder.Default
    private List<CommentDto> comments = new ArrayList<>();


    // Dto를 Entity로
    public BoardEntity toEntity(){
        return BoardEntity.builder()
        .author(this.author)
        .password(this.password)
        .content(this.content)
        .build();
    }

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
