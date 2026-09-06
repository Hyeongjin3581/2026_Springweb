package example.Practice4.Dto;

import java.time.LocalDateTime;

import example.Practice4.Entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor 
@Getter @Setter @ToString @Builder 
public class EnrollDto {

    private Integer enrollId;
    private String status;

    private Integer courseId;
    private String courseName;

    private Integer studentId;
    private String studentName;

    private LocalDateTime createDate;
    private  LocalDateTime upDateTime;

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
        .status(this.status)
        .build();
    }

    public static EnrollDto from(EnrollEntity enrollEntity){
        return EnrollDto.builder()
        .enrollId(enrollEntity.getEnrollId())
        .status(enrollEntity.getStatus())
        
        // Course 정보
        .courseId(enrollEntity.getCourseEntity().getCourseId())
        .courseName(enrollEntity.getCourseEntity().getCourseName())
        // Student 정보
        .studentId(enrollEntity.getStudentEntity().getStudentId())
        .studentName(enrollEntity.getStudentEntity().getStudentName())

        .createDate(enrollEntity.getCreateDate())
        .upDateTime(enrollEntity.getUpDateTime())
        .build();
    }
}
