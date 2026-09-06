package example.practice4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

}
