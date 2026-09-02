package example.Practice2;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    // 리포지토리객체 불러오기
    private final TestRepository testRepository;

    // [1] 게시물 등록
    public boolean testWrite(TestEntity entity){
        TestEntity saved = testRepository.save(entity);
        if(saved.getEno() >=1) return true;
        return false;
    }
    //[2] 전체조회
    public List<TestEntity>testPrint(){
        List<TestEntity> testEntities = testRepository.findAll();
        return testEntities;
    }

    //[3] 개별조회
    public TestEntity testDetail(int no){
        Optional<TestEntity> optional = testRepository.findById(no);

        if(optional.isPresent()){ return optional.get();}
        return null;
    }

    //[4] 게시물 삭제
    public boolean testDelete(int no){
        testRepository.deleteById(no);
        return true;
    }

    //[5] 게시물 수정
    @Transactional
     public boolean testUpdate(TestEntity entity){
        java.util.Optional<TestEntity> optional = testRepository.findById(entity.getEno());

        if(optional.isPresent()){
            TestEntity savedEntity = optional.get();
            
            savedEntity.setEcontent(entity.getEcontent());
            savedEntity.setEwriter(entity.getEwriter());
            return true;
        }
        return false;
     }

} // class end
