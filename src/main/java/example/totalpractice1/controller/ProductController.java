package example.totalpractice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.totalpractice1.Model.dto.ProductDto;
import example.totalpractice1.service.ProductService;

@RestController 
@CrossOrigin(value = "http://localhost:5173")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired private ProductService productService;
    // 1. 제품 등록기능
    @PostMapping("")
    public ProductDto 제품등록(@RequestBody ProductDto productDto){
        return productService.제품등록(productDto);
    }
    // 2. 제품 전체 조회기능
    @GetMapping("")
    public List<ProductDto>전체조회(){
        return productService.전체조회();
    }
    // 3. 제품 수정기능
    @PutMapping("")
    public boolean 제품수정(@RequestBody ProductDto productDto){
        return productService.제품수정(productDto);
    }
    // 4. 제품 삭제기능
    @DeleteMapping("")
    public boolean 제품삭제(
        @RequestParam(name="bno") Integer bno){
            return productService.제품삭제(bno);
        }
}
