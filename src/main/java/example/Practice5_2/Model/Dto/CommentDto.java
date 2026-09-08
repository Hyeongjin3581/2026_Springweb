package example.Practice5_2.Model.Dto;

import java.time.LocalDateTime;

import example.Practice5_2.Model.Entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder 
@Data 
public class CommentDto {
    private Integer commentId;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Integer boardId;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
        .author(this.author)
        .password(this.password)
        .content(this.content)
        .build();
    }
    public static CommentDto from(CommentEntity entity){
        return CommentDto.builder()
        .commentId(entity.getCommentId())
        .author(entity.getAuthor())
        .password(entity.getPassword())
        .content(entity.getContent())
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
    }
}
