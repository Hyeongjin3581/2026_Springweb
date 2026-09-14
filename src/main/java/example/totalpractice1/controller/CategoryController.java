package example.totalpractice1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.totalpractice1.model.dto.CategoryDto;
import example.totalpractice1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// asdf
@CrossOrigin (value = "http://localhost:5173")
@RestController @RequestMapping ("/api/categories")
@RequiredArgsConstructor 
public class CategoryController {
    private final CategoryService categoryService;

    // 카테고리 등록 기능
    @PostMapping("")
    public CategoryDto save(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    // 카테고리 전체 조회 기능
    @GetMapping("")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    // 카테고리 삭제 기능
    @DeleteMapping ("")
    public boolean delete(@RequestParam (name = "cno") Integer cno) {
        return categoryService.delete(cno);
    }
    
    
}