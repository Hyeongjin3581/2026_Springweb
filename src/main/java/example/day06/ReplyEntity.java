package example.day06;

import org.hibernate.engine.internal.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Table(name="reply")
@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class ReplyEntity {
    @Id 
    private Integer rno;
    private String rname;

    // 단방향 참조
    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "bno")
    @ToString.Exclude
    private BoardEntity boardEntity;

    
}

/*
    - 영속성이란? 자바는 휘발성, DB는 비 휘발성 / 서로 매핑하여 영속성(영구저장)표현
            -   Entity entity = new entity(); // 객체
            -   repository.save() / repository.findAll() / repository.findById() 등등 결과 영속됨.
            -   즉] Entity 영속된entity = repository.save(비영속entity) 
    - @ManyToOne (cascade = 영속성(CascadeType.ㅁ) , fetch = 불러오기시기)

    - CascadeType
        CascadeType.REMOVE : 만일 부모 엔티티가 삭제되면 자식 엔티티도 같이 삭제된다. 
        CascadeType.MERGE : 만일 부모 엔티티가 수정되면 자식 엔티티도 수정 같이 반영.
        CascadeType.DETACH : 만일 부모 엔티티가 영속(연결)해지되면, 자식 엔티티도 같이 해제한다.
        CascadeType.REFRESH : 만약 부모 엔티티가 재호출(갱신) 되면 자식 엔티티가 같이 갱신된다. 
        CascadeType.PERSIST : 만약 부모 엔티티가 저장하면 자식 엔티티도 같이 저장된다.
        CascadeType.All : 위 속성들을 모두 사용

    - fetch
        FetchType.LAZY : 해당 엔티티 조회시 자식(참조) 엔티티를 불러오지 않는다. (실무 테이블은 많기 때문에 성능저하방지)
            -   초기 로딩이 빠르다. 재사용성이 느리다, 필요한 정보만 불러온다<지연로딩>
            -   즉, 
        FetchType.EAGER : 해당 엔티티 조회시 자식(참조) 엔티티 (즉시) 불러온다.  - 부모 조회시 자식(손자)도 불러온다
            -   기본값 , 초기 로딩이 느리다. /  재사용성이 빠르다 / 불필요한 정보까지 불러온다. (성능저하)

*/
