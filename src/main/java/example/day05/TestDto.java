package example.day05;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder
public class TestDto { // 서로 계층간 이동객체 ( controller 에서는 엔티티 사용금지)
    // 엔티티와 동일하게 멤버변수 구성: 기능별로 DTO 구성 예] 등록 DTO , 조회 DTO, 수정 DTO
    private Integer no;
    private String name;
    private String descri;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime upDateTime;
    // 엔티티를 DTO로 변환하는 함수 필요, 그 반대도 필요.
    public TestEntity toEntity(){ // 주로 sava/update 목적으로 많이 사용 됨.
        return TestEntity.builder() // 빌더패턴이란? new 대신에 객체생성을 대신하는 메소드 방식 지원
       .name(this.name)
       .descri(this.descri)
       .price(this.price)
        .build();   // 빌더 패턴 끝
    }
    // ENTITY ---> DTO 함수 : S -> C(E -> D) , from(Entity entity) , 주로 find
    public static TestDto from(TestEntity testEntity){
        return TestDto.builder()
                .no(testEntity.getNo())
                .name(testEntity.getName())
                .descri(testEntity.getDescri())
                .price(testEntity.getPrice())
                .createDate(testEntity.getCreateDate())
                .upDateTime(testEntity.getUpDateTime())
                .build();
    }
}
