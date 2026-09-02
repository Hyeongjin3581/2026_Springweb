package example.day04;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository // 리포지토리(DB조작) 담당하는 객체(빈) 생성
public interface ExamRepository extends JpaRepository<ExamEntity ,Integer>{
    // 구현체란 ? 해당 인터페이스(추상) 구현한 객체
    // 제네릭 타입이란? 해당 클래스내 사용할 매개 타입
    //JpaRepository<조작할엔티티명,엔티티pk타입>
}
