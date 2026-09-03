package example.Practice3;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder
public class MovieDto {
    private Integer movieid;
    private String title;
    private String director;
    private String releasedate;
    private Double rating;
    private LocalDateTime createDate;
    private LocalDateTime upDateTime;

    public MovieEntity toEntity(){
        return MovieEntity.builder()
        .title(this.title)
        .director(this.director)
        .releasedate(this.releasedate)
        .rating(this.rating)
        .build();
    }
    public static MovieDto from(MovieEntity movieEntity){
        return MovieDto.builder()
        .movieid(movieEntity.getMovieid())
        .title(movieEntity.getTitle())
        .director(movieEntity.getDirector())
        .releasedate(movieEntity.getReleasedate())
        .rating(movieEntity.getRating())
        .createDate(movieEntity.getCreateDate())
        .upDateTime(movieEntity.getUpDateTime())
        .build();
    }
} // class end
