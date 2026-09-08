package example.Practice404.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.Practice404.Model.Dto.EnrollDto;
import example.Practice404.Service.EnrollService;

@RestController 
@RequestMapping ("/api/enroll")
public class EnrollController {
    @Autowired private EnrollService enrollService;

    @PostMapping ("")
    public boolean 수강등록(@RequestBody EnrollDto enrollDto){
        return enrollService.수강등록(enrollDto);
    }

    @GetMapping("/detail")
    public EnrollDto 수강조회(@RequestParam (name = "enrollId")Integer enrollId){
        return enrollService.수강조회( enrollId );
    }
}
