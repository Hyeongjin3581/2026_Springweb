package example.day09.controller;

import org.springframework.web.bind.annotation.RestController;

import example.day08.ApiService;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
public class ApiController {
    private final ApiService apiService;

    
}
