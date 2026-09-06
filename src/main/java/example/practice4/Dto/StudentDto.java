package example.practice4.Dto;

import java.time.LocalDateTime;

import example.practice4.Entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor 
@Getter @Setter @ToString @Builder 
public class StudentDto {
    private Integer studentId;
    private String studentName;
    private LocalDateTime createDate;
    private LocalDateTime upDateTime;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
        .studentName(this.studentName)
        .build();
    }

    public static StudentDto from(StudentEntity studentEntity){
        return StudentDto.builder()
        .studentId(studentEntity.getStudentId())
        .studentName(studentEntity.getStudentName())
        .createDate(studentEntity.getCreateDate())
        .upDateTime(studentEntity.getUpDateTime())
        .build();
    }
}
