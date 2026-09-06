package example.practice4;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice4.Dto.CourseDto;
import example.practice4.Dto.EnrollDto;
import example.practice4.Dto.StudentDto;
import example.practice4.Entity.CourseEntity;
import example.practice4.Entity.EnrollEntity;
import example.practice4.Entity.StudentEntity;
import example.practice4.Repository.CourseRepository;
import example.practice4.Repository.EnrollRepository;
import example.practice4.Repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class P4Service {

    @Autowired 
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;     

    @Autowired 
    private EnrollRepository enrollRepository;

    // 1. 과정등록
    public boolean 과정등록(CourseDto courseDto){
        CourseEntity courseEntity = courseDto.toEntity();
        CourseEntity savedEntity = courseRepository.save(courseEntity);
        if(savedEntity.getCourseId()>=1){return true;}
        return false;
    }
    
    // 2. 학생 등록
    public boolean 학생등록(StudentDto studentDto){
        StudentEntity studentEntity = studentDto.toEntity();
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        if(savedEntity.getStudentId()>=1){return true;}
        return false;
    }

    // 3. 수강등록
    @Transactional 
    public boolean 수강등록(EnrollDto enrollDto){
        // 3-1 . Dto에서 학생번호를 가져와 학생Entity조회.
        Optional<StudentEntity> studentOptional = studentRepository.findById(enrollDto.getStudentId());
        // 3-2. Dto에서 과정번호를 가져와 과정 Entity를 조회.
        Optional<CourseEntity> courseOptional = courseRepository.findById(enrollDto.getCourseId());
        // 3-3. 학생 혹은 과정번호가 존재하지 않다면 등록에 실패.
        if(studentOptional.isEmpty() || courseOptional.isEmpty()){return false;}
        
        // 3-4 Optional에서 StudentEntity꺼내오기
        StudentEntity studentEntity = studentOptional.get();
        //3-5 Optional에서 courseEntity 꺼내기
        CourseEntity courseEntity = courseOptional.get();
        // 3-6 EnrollDto => EnrollEntity 반환
        EnrollEntity enrollEntity = enrollDto.toEntity();
        //3-7 조회한 학생 Entity 반환
        enrollEntity.setStudentEntity(studentEntity);
        //3-8 조회한과정 Entity연결
        enrollEntity.setCourseEntity(courseEntity);
        //3-9 수강정보 저장
        EnrollEntity savedEntity = enrollRepository.save(enrollEntity);
        //3-10 pk가 생성됐는지 확인
        if(savedEntity.getEnrollId()>=1){return true;}
        return false;
    }

    // 4. 수강정보조회
    @Transactional(readOnly = true)
    public EnrollDto 수강조회(Integer enrollId){
        //4-1. enrollId를 이용해 EnrollEntity 조회
        Optional<EnrollEntity> optional = enrollRepository.findById(enrollId);
        //4-2. 조회한 수강정보가 존재한다면
        if(optional.isPresent()){
            //4-3 Optional -> Entity
            EnrollEntity enrollEntity = optional.get();
            //4-4 Entity -> Dto 변환
            EnrollDto enrollDto = EnrollDto.from(enrollEntity);
            //4-5 Dto반환
            return enrollDto;
        }
        return null;
    }

    //5. 학생삭제
@Transactional
public boolean 학생삭제(Integer studentId){
    // 5-1. 삭제할 학생 조회
    Optional<StudentEntity> optional = studentRepository.findById(studentId);

    // 5-2. 학생이 존재한다면
    if(optional.isPresent()){
        // 5-3. StudentEntity 꺼내기
        StudentEntity studentEntity = optional.get();
        // 5-4. 해당 학생의 수강기록 먼저 삭제
        enrollRepository.deleteAll( studentEntity.getEnrollList());
        // 5-5. 학생 삭제
        studentRepository.delete(studentEntity);
        return true;
    }
    return false;
}

} // class end
