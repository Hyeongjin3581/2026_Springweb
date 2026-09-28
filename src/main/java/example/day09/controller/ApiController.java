package example.day09.controller;

import org.springframework.web.bind.annotation.RestController;

import example.day09.model.dto.ApiDto;
import example.day09.service.ApiService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequiredArgsConstructor 
@CrossOrigin ("http://localhost:5173")
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/list")
    public List<ApiDto>findAll(){
        return apiService.findAll();
    }

    @PostMapping("/write")
    public boolean save(@RequestBody ApiDto apiDto){
        return apiService.save(apiDto);
    }
    
    
    
}
