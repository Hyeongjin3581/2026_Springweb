package example.Practice404.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.Practice404.Model.Dto.StudentDto;
import example.Practice404.Service.StudentService;

@RestController 
@RequestMapping ("/api/student")
public class StudentController {
    @Autowired private StudentService studentService;

    
 	
    @PostMapping("")
    public boolean 학생등록( 
        @RequestBody StudentDto studentDto){
        return studentService.학생등록(studentDto);
    }
    @DeleteMapping("")
    public boolean 학생삭제(
        @RequestParam( name = "studentId") Integer studentId ){
        return studentService.학생삭제( studentId );
    }
}
