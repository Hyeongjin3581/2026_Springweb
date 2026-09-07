package example.Practice4_1.Model.Entity;

import java.util.ArrayList;
import java.util.List;

import example.Practice3.BaseTime;
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
@Table(name="course")
@NoArgsConstructor @AllArgsConstructor 
@Data @Builder 
public class CourseEntity extends BaseTime {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer courseId;
    private  String courseName;

    @OneToMany(mappedBy = "courseEntity ", cascade = CascadeType.ALL , fetch = FetchType.LAZY) // 1 : M  
    //@OneToMany(mappedBy = "매핑할 멤버변수명")  
    @ToString.Exclude // 순환참조방지
    @Builder.Default // 빌더패턴 사용시 초기값 사용
    private List<EnrollEntity> entities = new ArrayList<>();
}
