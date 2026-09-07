package example.Practice404.Model.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.Practice404.Model.Entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder 
@Data 
public class CourseDto {
    private Integer courseId;
    private String courseName;
    private  LocalDateTime createAt;
    private  LocalDateTime upDateAt;

    // + 학생등록 
    //과정 자체를 저장하기 위한 필드라기보다, 과정 조회 시 
    // 학생 목록까지 같이 보여주기 위한 DTO용 필드라고 이해하는 게 좋아.
    @Builder.Default
    private List<StudentDto> studentDtos = new ArrayList<>();

    public CourseEntity toEntity(){
        return CourseEntity.builder()
        .courseName(this.courseName)
        .build();
    }

    public static CourseDto from(CourseEntity entity){
        return CourseDto.builder()
        .courseId(entity.getCourseId())
        .courseName(entity.getCourseName())
        .createAt(entity.getCreateAt())     
        .upDateAt(entity.getUpDateAt()) 
        .build();
    }
}
