package example.Practice5.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice5.Model.Entity.CommentEntity;

@Repository 
public interface  CommentRepository extends JpaRepository<CommentEntity,Integer> {

}
