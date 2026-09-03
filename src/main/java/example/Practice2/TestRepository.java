package example.Practice2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity,Integer>{
}


/*
    extends JpaRepository<TestEntity, Integer>

    TestEntity : Repository가 관리할 Entity
    Integer    : TestEntity의 @Id(PK) 자료형

    1. 기본 CRUD 기능 제공
       - save()       : 등록 / 수정
       - findById()   : PK 기준 개별 조회
       - findAll()    : 전체 조회
       - deleteById() : PK 기준 삭제
       - count()      : 데이터 개수 조회
       - existsById() : 데이터 존재 여부 확인

    2. 페이징 / 정렬 기능 제공
       - PageRequest
       - Pageable
       - Sort

    3. 사용자 정의 조회 기능 제공
       - findByName()
       - findByNameAndAge()
       - findByNameContaining()
       - @Query를 이용한 JPQL 작성
*/