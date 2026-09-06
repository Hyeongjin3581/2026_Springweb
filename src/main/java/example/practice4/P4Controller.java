package example.practice4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import example.practice4.Dto.CourseDto;
import example.practice4.Dto.EnrollDto;
import example.practice4.Dto.StudentDto;

@RestController
public class P4Controller {

    @Autowired
    private P4Service p4Service;

    // 1. 과정등록
    @PostMapping("/course")
    public boolean 과정등록(@RequestBody CourseDto courseDto) {
        return p4Service.과정등록(courseDto);
    }

    // 2. 학생등록
    @PostMapping("/student")
    public boolean 학생등록(@RequestBody StudentDto studentDto) {
        return p4Service.학생등록(studentDto);
    }

    // 3. 수강등록
    @PostMapping("/enroll")
    public boolean 수강등록(@RequestBody EnrollDto enrollDto) {
        return p4Service.수강등록(enrollDto);
    }

    // 4. 수강 상세 조회
    @GetMapping("/enroll/detail/{enrollId}")
    public EnrollDto 수강조회(@PathVariable("enrollId") Integer enrollId){
        return p4Service.수강조회(enrollId);
    }

    // 5. 학생 삭제
    @DeleteMapping("/student/{studentId}")
    public boolean 학생삭제(@PathVariable("studentId") Integer studentId){
        return p4Service.학생삭제(studentId);
    }

} // class end