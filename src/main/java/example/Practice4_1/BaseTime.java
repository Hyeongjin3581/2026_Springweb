package example.Practice4_1;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 자식 클래스 호출
@NoArgsConstructor 
@MappedSuperclass  // 테이블이 아닌 상속용도
@EntityListeners (AuditingEntityListener.class) // 감시기능
public class BaseTime {
    @CreatedDate // 
    private LocalDateTime createAt;
    @LastModifiedDate // 마지막 수정 시간 자동 저장
    private LocalDateTime upDateAt;
}
