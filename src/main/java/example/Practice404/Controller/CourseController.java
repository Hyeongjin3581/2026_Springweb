package example.Practice404.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Practice404.Model.Dto.CourseDto;
import example.Practice404.Service.CourseService;

@RestController 
@RequestMapping ("/api/course")
public class CourseController {
    @Autowired private  CourseService courseService;

    @PostMapping("")
    public boolean 과정등록(@RequestBody CourseDto courseDto){
        return courseService.과정등록(courseDto);
    }

    @GetMapping("")
    public List<CourseDto> 과정전체조회(){
        return courseService.과정전체조회();
    }
}
