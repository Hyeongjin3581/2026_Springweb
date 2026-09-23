package example.day09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.day09.model.repository.ApiRepository;

@Service 
public class ApiService {
    @Autowired private ApiRepository apiRepository;
}
