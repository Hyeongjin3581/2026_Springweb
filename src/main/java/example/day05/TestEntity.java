package example.day05;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "test")
@NoArgsConstructor@AllArgsConstructor@Builder
@Getter@Setter@ToString
public class TestEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    @Column (name="name", nullable = false , length = 100 , unique = true) // 제약조건 설정
    private String name; // 이름
    @Column( columnDefinition = "varchar(100) not null default '제품설명' ")
    private String descri; // 설명
    @Column(insertable =  true , updatable = true)
    private Integer price; // 가격
}

/*
@Column (name="필드명") : 셍략 시 자동으로 멤버변수명으로 지정
@Column (name="name",nullable = true/false) : not null 구별가능
@Column (name="name",nullable = true/false , length = "문자열길이~255" , unique(중복구별)) 
@Column( columnDefinition = "SQL 구문")
@Column(insertable =  inser여부 , updatable = update 여부)
*/