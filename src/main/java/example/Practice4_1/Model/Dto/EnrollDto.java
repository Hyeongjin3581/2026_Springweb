package example.Practice4_1.Model.Dto;

import java.time.LocalDateTime;

import example.Practice4.Entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder 
@Data 
public class EnrollDto {
    private Integer enrollId;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime upDateAt;

    // 자바(JPA)에서 entity로 PK를 사용하지만, 입력받을 경우 PK번호를 받는다.
    private Integer courseId;
    private Integer studentId;


    // + 과정명 , 학생명
    private String courseName;
    private String studentName;

    // +toEntity
    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
        .status(this.status)
        // 학생 FK , 과정 FK는 서비스에서 엔티티로 변환
        .build();
    }
    public EnrollDto from(EnrollDto entity){
        return EnrollDto.builder()
        .enrollId(entity.getEnrollId())
        .status(entity.getStatus())
        // 과정엔티티 내 과정명만 조회
        .courseName(entity.getCourseName())
        // 학생엔티티 내 학생명만 조회
        .studentName(entity.getStudentName())

        .createAt(entity.getCreateAt())
        .upDateAt(entity.getUpDateAt())
        .build();
    }
}

// join 형식은 sql방식이고, 
// java는 JPA기반으로 데이터를 조회하기 때문에 해당 방식을 사용. (JAVA의 참조방식.)