package example.Practice4_1.Model.Dto;

import java.time.LocalDateTime;

import example.Practice4_1.Model.Entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder 
@Data 
public class StudentDto {
    private Integer studentId;
    private  String studentName;
    private LocalDateTime createAt;
    private  LocalDateTime upDateAt;

    // Dto -> Entity
    // 학생 등록 용도
    public StudentEntity toEntity(){
        return StudentEntity.builder()
        .studentName(this.studentName)
        .build();
    }

    // Entity - > Dto 
    public static StudentDto from(StudentEntity entity){
        return StudentDto.builder()
        .studentId(entity.getStudentId())
        .studentName(entity.getStudentName())
        .createAt(entity.getCreateAt())
        .upDateAt(entity.getUpDateAt())
        .build();
    }
}
