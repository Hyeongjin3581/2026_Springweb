package example.day09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.day09.model.dto.ApiDto;
import example.day09.model.entity.ApiEntity;
import example.day09.model.repository.ApiRepository;

@Service 
public class ApiService {
    @Autowired private ApiRepository apiRepository;

    // 전체조회
    public List<ApiDto> findAll(){
        List<ApiEntity> apiEntities = apiRepository.findAll();
        List<ApiDto> apiDtos = apiEntities.stream().map((entity) -> { return ApiDto.from(entity); }).toList();

        return apiDtos;
    }

    // 작성
    public boolean save(ApiDto apiDto){
        ApiEntity apiEntity = apiDto.toEntity();
        apiRepository.save(apiEntity);
        ApiEntity saved = apiRepository.save(apiEntity);
        if(saved.getIdx() >= 1){
            return true;
        }
        return false;
    }

}
