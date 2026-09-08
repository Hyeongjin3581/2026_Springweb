package example.Practice5_2.Model.Repository;

import example.Practice5_2.Model.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {

}
