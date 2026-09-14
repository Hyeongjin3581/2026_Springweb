package example.totalpractice1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import example.totalpractice1.model.dto.CategoryDto;
import example.totalpractice1.model.entity.CategoryEntity;
import example.totalpractice1.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
@Service @RequiredArgsConstructor 

public class CategoryService {
    private final CategoryRepository categoryRepository;

    // 카테고리 등록 기능
    public CategoryDto save(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = categoryDto.toEntity();
        CategoryEntity savedEntity = categoryRepository.save(categoryEntity);
        if( savedEntity.getCno() >= 1 ) return categoryDto;
        return null;
    }

    // 카테고리 전체 조회 기능
    public List<CategoryDto> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryEntities.forEach( entity -> {
            CategoryDto categoryDto = CategoryDto.from(entity);
            categoryDtos.add(categoryDto);
        });
        return categoryDtos;
    }

    // 카테고리 삭제 기능
    public boolean delete(Integer cno) {
        CategoryEntity categoryEntity = categoryRepository.findById(cno).orElse(null);
        if( categoryEntity != null ){
            categoryRepository.deleteById(cno);
            return true;
        }
        return false;
    }
}