package example.practice4.Dto;

import java.time.LocalDateTime;

import example.practice4.Entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor 
@Getter @Setter @ToString @Builder 
public class CourseDto {
    private Integer courseId;
    private String courseName;
    private LocalDateTime createDate;
    private  LocalDateTime upDateTime;
    
    public CourseEntity toEntity(){
        return CourseEntity.builder()
        .courseName(this.courseName)
        .build();
    }

    public static CourseDto from(CourseEntity cousrseEntity){
        return CourseDto.builder()
        .courseId(cousrseEntity.getCourseId())
        .courseName(cousrseEntity.getCourseName())
        .createDate(cousrseEntity.getCreateDate())
        .upDateTime(cousrseEntity.getUpDateTime())
        .build();
    }

}
