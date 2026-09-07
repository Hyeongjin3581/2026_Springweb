package example.Practice404.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import example.Practice404.Model.Dto.StudentDto;
import example.Practice404.Model.Entity.StudentEntity;
import example.Practice404.Model.Repository.StudentRepository;

public class StudentService {
    @Autowired private StudentRepository studentRepository;

    
 	
    // 1. 학생등록
    public boolean 학생등록( StudentDto studentDto ){
        StudentEntity studentEntity = studentDto.toEntity();
        StudentEntity savedEntity = studentRepository.save( studentEntity );
        if( savedEntity.getStudentId() >=1 ) return true;
        return false;
    }
    // 2. 학생삭제
    public boolean 학생삭제( Integer studentId ){
        // 1. 학생번호 이용한 학생엔티티 찾기
        Optional<StudentEntity> optional = studentRepository.findById(studentId);
        // 2. 만일 엔티티 존재하면
        if( optional.isPresent() ){
            studentRepository.deleteById( studentId );
            return true;
        }
        return false; 
    }

}
