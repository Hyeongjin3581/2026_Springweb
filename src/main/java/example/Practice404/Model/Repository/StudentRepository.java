package example.Practice404.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice404.Model.Entity.StudentEntity;


@Repository 
public interface  StudentRepository extends JpaRepository<StudentEntity , Integer> {

}
