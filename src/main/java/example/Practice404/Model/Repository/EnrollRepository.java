package example.Practice404.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice404.Model.Entity.EnrollEntity;

@Repository 
public interface  EnrollRepository extends  JpaRepository<EnrollEntity,Integer>{

}
