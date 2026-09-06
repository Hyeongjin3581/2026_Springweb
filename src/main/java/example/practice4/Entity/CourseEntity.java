package example.practice4.Entity;

import java.util.ArrayList;
import java.util.List;

import example.practice4.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="course")
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter 
public class CourseEntity extends BaseTime{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer courseId;

    private String courseName;


    // Enroll N : 1 Course
    @OneToMany (mappedBy = "courseEntity")
    @Builder.Default
    @ToString.Exclude
    private List<EnrollEntity> enrollList = new ArrayList<>();
}
