package example.Practice404.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice404.Model.Dto.CourseDto;
import example.Practice404.Model.Dto.EnrollDto;
import example.Practice404.Model.Entity.CourseEntity;
import example.Practice404.Model.Entity.EnrollEntity;
import example.Practice404.Model.Entity.StudentEntity;
import example.Practice404.Model.Repository.CourseRepository;
import example.Practice404.Model.Repository.EnrollRepository;
import example.Practice404.Model.Repository.StudentRepository;



@Service 
public class EnrollService {
    @Autowired private CourseRepository courseRepository;
    @Autowired private EnrollRepository enrollRepository;
    @Autowired private StudentRepository studentRepository;

    // 1. 수강 등록
    public boolean 수강등록(EnrollDto enrollDto){
        EnrollEntity enrollEntity = enrollDto.toEntity();
        Optional<StudentEntity> optional1 = studentRepository.findById(enrollDto.getStudentId());
        Optional<CourseEntity> optional2 = courseRepository.findById(enrollDto.getStudentId());
        
        if(optional1.isPresent() && optional2.isPresent()){
            // 학생엔티티 꺼내서 enroll 엔티티에 대입
            StudentEntity studentEntity = optional1.get();
            enrollEntity.setStudentEntity(studentEntity);
            // 과정엔티티 꺼내서 enroll 엔티티에 대입
            CourseEntity courseEntity = optional2.get();
            enrollEntity.setCourseEntity(courseEntity);
            // 2. FK엔티티 대입 후 , entity save.
            EnrollEntity savedEntity = enrollRepository.save(enrollEntity);
            if(savedEntity.getEnrollId()>=1)return true;
        }
        return false;

    }
    // 2. 수강조회
    public EnrollDto 수강조회(Integer enrollId){
        // Optional<> 클래스는 null 예외검사 메소드 제공 , isPresent() 있으면 true/false. orElse(없을 때 자료)
        EnrollEntity enrollEntity = enrollRepository.findById(enrollId).orElse(null);
        return EnrollDto.from(enrollEntity);
    }
}
