package example.Practice5_2;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@NoArgsConstructor 
@MappedSuperclass 
@EntityListeners(AuditingEntityListener.class) // 감시기능
public class BaseTime {
    @CreatedDate private LocalDateTime createdAt;
    @LastModifiedDate private  LocalDateTime updatedAt;
}
