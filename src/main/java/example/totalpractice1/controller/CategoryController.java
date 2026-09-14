package example.totalpractice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.totalpractice1.model.dto.CategoryDto;

@RestController 
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired private CategoryService categoryService;

    // 1. 카테고리 등록
    @PostMapping("")
    public CategoryDto 카테고리등록(@RequestBody CategoryDto categoryDto){
        return categoryService.카테고리등록(categoryDto);
    }

    // 2. 카테고리 전체 조회기능
    @GetMapping("")
    public List<CategoryDto>전체조회(){
        return categoryService.전체조회();
    }

    // 3. 카테고리 삭제
    @DeleteMapping("")
}
