package example.Practice5.Model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice5.Model.Entity.BoardEntity;

@Repository 
public interface BoardRepository extends JpaRepository<BoardEntity,Integer>{

    Optional<BoardEntity> findByPassword(String password);

}
