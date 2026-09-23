package example.react__practice1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ApiController {

    @Autowired 
    private  ApiService apiService;

    @GetMapping(
    value = "/testJin",
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Map<String, Object> testJin() {
        return apiService.testJin();
    }
}
