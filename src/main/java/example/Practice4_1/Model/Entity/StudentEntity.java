package example.Practice4_1.Model.Entity;

import java.util.ArrayList;
import java.util.List;

import example.Practice4_1.BaseTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Table (name="student")
@NoArgsConstructor @AllArgsConstructor 
@Data @Builder 
public class StudentEntity extends BaseTime {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;

    @OneToMany (mappedBy ="studentEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude // 순환참조방지
    @Builder.Default // 빌더패턴 사용시 초기값 사용
    private List<EnrollEntity> students = new ArrayList<>(); 
}
