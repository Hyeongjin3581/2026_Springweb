package example.practice4.Entity;

import example.practice4.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="enroll")
@NoArgsConstructor@AllArgsConstructor @Builder 
@Getter @Setter 
public class EnrollEntity extends BaseTime{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer enrollID;

    private String status;

    // 과정번호 FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name ="courseId")
    private CourseEntity courseEntity;

    // 학생번호 FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;
}
