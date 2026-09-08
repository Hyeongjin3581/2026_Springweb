package example.Practice5.Model.Dto;

import java.time.LocalDateTime;

import example.Practice5.Model.Entity.CommentEntity;
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
    private LocalDateTime upDatedAt;

    private Integer boardId; // 서비스에서 쓸께용

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
                .boardId(entity.getBoardEntity().getId())
                .createdAt(entity.getCreatedAt())
                .upDatedAt(entity.getUpdatedAt())
                .build();
    }
}
