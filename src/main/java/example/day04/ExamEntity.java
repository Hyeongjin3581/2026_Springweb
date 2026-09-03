package example.day04;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// mvc 패턴 중 m(dao)
@Entity // 엔티티 클래스의 객체(빈) 생성
@Table(name = "exam") // (매핑/연결) 할 DB테이블의 이름 정의 / 생략 시 class명으로 들어감. 
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class ExamEntity {
    // Entity는 무조건 1개 이상의 PK를 가진다.
    @Id // Primary Key 지점
    @GeneratedValue( strategy = GenerationType.IDENTITY)    // GenerationType.IDENTITY = auto_increment (mysql만 지원함.)
    private Integer eno;
    private String ename;
}
