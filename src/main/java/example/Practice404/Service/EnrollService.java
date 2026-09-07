package example.Practice404.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice404.Model.Dto.CourseDto;
import example.Practice404.Model.Entity.CourseEntity;
import example.Practice404.Model.Repository.CourseRepository;
import example.Practice404.Model.Repository.EnrollRepository;



@Service 
public class EnrollService {
    @Autowired private CourseRepository courseRepository;
    @Autowired private EnrollRepository enrollRepository;

    // 1. 등록
    public boolean 과정등록(CourseDto courseDto){
        CourseEntity courseEntity = courseDto.toEntity(); // 1. Dto -> Entity 변환
        CourseEntity saveEntity = courseRepository.save( courseEntity ); // 2. entity 저장하기
        if(saveEntity.getCourseId()>=1) return true; // 3. 등록된 entity에 pk 존재하면 
        return false;
    }
}
