package example.practice4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface StudentEntity extends JpaRepository<StudentEntity,Integer>{

}
