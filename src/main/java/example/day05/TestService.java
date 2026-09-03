package example.day05;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class TestService {
    @Autowired private TestRepository testRepository;

    //1. 전체조회
    public List<TestDto>전체조회(){
        // 1. 모든 엔티티 조회한다. 
        List<TestEntity> entities = testRepository.findAll();
        // 2. 모든 엔티티 -> DTO 변환하기
        // 빈 리스트 생성
        List<TestDto> list = new ArrayList<>();
        // 모든 엔티티 반복하여 모든 DTO 변환해서 새로운 리스트 저장
        entities.forEach(entity -> {
            list.add(TestDto.from(entity));
        });
        return list;
    }

    // 2. 저장
    public boolean 저장(TestDto testDto){
        // 1. dto --> Entity 변환함수 : toEntity함수
        TestEntity testEntity = testDto.toEntity();
        // 2. entity save 저장
        TestEntity savedtEntity = testRepository.save(testEntity);
        //3. 
        if(savedtEntity.getNo()>=1) {return true;}
        return false;
    }
    // 3. 수정
    @Transactional
    public boolean 수정(TestDto testDto){
        // 1. 수정할 엔티티를 찾는다 .pk
    Optional<TestEntity> optional = testRepository.findById(testDto.getNo());
        // 2. 찾은 엔티티가 존재하면
        if(optional.isPresent()){
            //3. 엔티티를 꺼낸다
            TestEntity entity = optional.get();
            // 4. setter 메소드 이용한 수정
            entity.setPrice(testDto.getPrice());
            entity.setDescri(testDto.getDescri());
            return true;
        }
        return false;
    }

}
