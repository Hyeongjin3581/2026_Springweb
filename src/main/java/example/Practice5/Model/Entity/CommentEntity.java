package example.Practice5.Model.Entity;

import example.Practice5.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="comment")
@NoArgsConstructor @AllArgsConstructor 
@Data @Builder
public class CommentEntity extends BaseTime{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String author;
    private String password;
    private String content;
     
    // ------------------- PK : 게시글번호 -------------------
    @JoinColumn (name = "board_id")
    @ManyToOne 
    private BoardEntity boardEntity;


}
