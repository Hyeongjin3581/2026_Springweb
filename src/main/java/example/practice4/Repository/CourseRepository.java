package example.Practice4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice4.Entity.CourseEntity;

@Repository 
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {

}
