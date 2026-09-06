package example.practice4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.practice4.Entity.CourseEntity;

@Repository 
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {

}
