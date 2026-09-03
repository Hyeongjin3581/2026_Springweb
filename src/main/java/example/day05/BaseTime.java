package example.day05;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 조회를 위한 Getter 함수
@NoArgsConstructor // 기본생성자 자동생성
@MappedSuperclass // 현재 클래스는 상속용 매핑이라는 것을 알려주는 어노테이션
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    // 1. 레코드 생성시점
    @CreatedDate
    private LocalDateTime createDate;
    // 2. 레코드 변경시점
    @LastModifiedDate
    private LocalDateTime upDateTime;
}
