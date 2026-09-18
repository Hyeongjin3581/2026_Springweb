package example.day08;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ApiController {

    @Autowired 
    private  ApiService apiService;


    @GetMapping("/api/test1")
    public Map<String, Object> test1() {
        return apiService.test1();
    }

    // 2. 
   @GetMapping("/api/test2")
    public Map<String, Object> test2(){
    return apiService.test2();
    }

    // 3.
    @GetMapping("/api/test3")
    public List<Map<String , Object>>test3(){
        return apiService.test3();
    }
    
}