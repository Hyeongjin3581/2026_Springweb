package example.totalpractice1.model.dto;

import example.totalpractice1.model.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class ReviewDto {
    private Integer mo;
    private Integer bno;

    private String reviewer;
    private String content;

    private Integer rating;

    public ReviewEntity toEntity(){
        return ReviewEntity.builder()
            .mo(this.mo)
            .reviewer(this.reviewer)
            .content(this.content)
            .rating(this.rating)
            .build();
    }

    public static ReviewDto from(ReviewEntity reviewEntity){
        return ReviewDto.builder()
            .mo(reviewEntity.getMo())
            .reviewer(reviewEntity.getReviewer())
            .content(reviewEntity.getContent())
            .rating(reviewEntity.getRating())
            .build();
    }
}