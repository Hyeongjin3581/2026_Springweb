package example.Practice3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="movie")
@NoArgsConstructor@AllArgsConstructor@Builder
@Getter@Setter@ToString
public class MovieEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieid;
    // 교수님은 ( nullable = false ) 넣으셔서 Not null 만드심. 
    private String title;
    private String director;
    private String releasedate;
    private Double rating;
}
