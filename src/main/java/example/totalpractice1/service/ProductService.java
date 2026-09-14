package example.totalpractice1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.totalpractice1.model.dto.ProductDto;
import example.totalpractice1.model.entity.CategoryEntity;
import example.totalpractice1.model.entity.ProductEntity;
import example.totalpractice1.model.repository.CategoryRepository;
import example.totalpractice1.model.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service 
public class ProductService {
    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryRepository categoryRepository;

    // 1. 제품 등록 기능
    public ProductDto 제품등록(ProductDto productDto){
        if(productDto.getCno() == null){
            return null;
        }

        ProductEntity productEntity = productDto.toEntity();
        CategoryEntity categoryEntity = categoryRepository.findById(productDto.getCno())
        .orElse(null);
        if(categoryEntity == null){
            return null;
        }
        productEntity.setCategoryEntity(categoryEntity);

        ProductEntity savedEntity = productRepository.save(productEntity);
        return ProductDto.from(savedEntity);
    }
    // 2. 제품 전체 조회 기능
    public List<ProductDto> 전체조회(){
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        productEntities.forEach((productEntity) ->{
            productDtos.add(ProductDto.from(productEntity));
        });
        return productDtos;
    }

    // 3. 제품 수정 기능
    @Transactional 
    public boolean 제품수정(ProductDto productDto){
        Optional<ProductEntity>optional = productRepository.findById(productDto.getBno());
        if(optional.isPresent()){
            ProductEntity entity = optional.get();
            entity.setBno(productDto.getBno());
            entity.setName(productDto.getName());
            entity.setPrice(productDto.getPrice());
            if(productDto.getCno() == null){
                return false;
            }

            CategoryEntity categoryEntity = categoryRepository.findById(productDto.getCno())
            .orElse(null);
            if(categoryEntity == null){
                return false;
            }
            entity.setCategoryEntity(categoryEntity);
            return true;
        }
        return false;
    }

    //4. 제품 삭제 기능
    public boolean 제품삭제(Integer bno){
        ProductEntity productEntity = productRepository.findById(bno).orElse(null);
        if(productEntity !=null){
            productRepository.deleteById(bno);
            return true;
        }
        return false;
    }
}