package example.day04;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

//(mcv패턴 중  v)
@Service // 해당 클래스가 비지니스로직을 담당하는 객체(빈) 생성 
@RequiredArgsConstructor
public class ExamService {
    // * 리포지토리객체 (주입) 불러오기
    private final ExamRepository examRepository;

    //[1] 전체조회
    public List<ExamEntity> findAll(){
        //리포지토리 호출
        // 리포지토리객체.findAll() : 구현체 select 지원
        return examRepository.findAll();
    }
    //[2] 저장
    public boolean 저장(ExamEntity entity){
        //리포지토리 호출
        //리포지토리 객체.save(저장할 entity) : insert 지원
        //save 반환값은 영속(매핑/저장)된 엔티티 반환
        ExamEntity saved = examRepository.save( entity );
        if( saved.getEno() >= 1)  return true;
        return false;
    }


    //[3] 삭제
    public boolean 삭제(int no){
        //리포지토리 호출
        //리포지토리객체.deleteId(삭제할PK번호) : delete SQL 지원
        // 반환타입 : 없음 , 삭제여부 findxxx 이용하여 확인
        examRepository.deleteById(no);
        return true;
    }

    //[4] 수정  --> 관례쩍으로 트랜잭션 필수. 
    @Transactional // 트랜잭션이란? 여러개 SQL 하나의 (논리) 단위로 묶음. 
    // 만약에 여러개 SQL중 하나라도 SQL 오류이면 전체 ROLLBACK 모두 성공하면 COMIT
    // 활용처 : 계좌이체(출금/입금) , 회원가입 포인트지급(회원가입/가입포인트 지급) :  2개 이상의 기능을 하나로 묶을 때 트랜잭션 활용. 
    public boolean 수정(ExamEntity entity){
        //1.  영속된 엔티티 조회 [PK : 수정할 번호]
        // 리포지토리객체.findById(조회할 pk번호) : select SQL 지원
        // Optional 클래스란? 본문(객체) 감싼 클래스(왜? null 예외 안전하게 사용)
        // -> 만약에 조회 결과 엔티티가 없을때 .getEno() 오류가 발생
        // Optional<객체타입> 변수명; 객체 래핑하여 null 검사 지원
        Optional<ExamEntity> optional = examRepository.findById(entity.getEno());
        // 2. 조회된 결과 엔티티 여부 확인
        if(optional.isPresent()){// 객체가 있으면 true; 없으면 false; (sql에서 레코드가 없을 수도 있기 때문에 래핑하여 반환.)
           ExamEntity savedEntity = optional.get(); // 래핑된 Optional에서 엔티티 꺼내기
           // 3. 만약에 엔티티가 존재하면 수정
           savedEntity.setEname(entity.getEname());
           return true;
        }
        return false;
    }
}
