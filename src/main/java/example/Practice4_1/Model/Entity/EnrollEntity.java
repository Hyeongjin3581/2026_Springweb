package example.Practice4_1.Model.Entity;

import example.Practice4_1.BaseTime;
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
@Table(name ="enroll")
@NoArgsConstructor @AllArgsConstructor 
@Data @Builder 
public class EnrollEntity extends BaseTime {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer enrollId;
    private String status;

    // ------------------- PK : 과정번호 -------------------
    @JoinColumn (name = "course_id")
    @ManyToOne // M : 1 , DB에서는 PK표시되고, JAVA에서는 객체로 표시.
    private CourseEntity courseEntity; 
    // ------------------- PK : 학생번호 -------------------
    @JoinColumn (name="student_id")
    @ManyToOne 
    private StudentEntity studentEntity;
}
