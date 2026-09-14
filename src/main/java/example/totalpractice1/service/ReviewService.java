package example.totalpractice1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.totalpractice1.model.dto.ReviewDto;
import example.totalpractice1.model.entity.ProductEntity;
import example.totalpractice1.model.entity.ReviewEntity;
import example.totalpractice1.model.repository.ProductRepository;
import example.totalpractice1.model.repository.ReviewRepository;

@Service 
public class ReviewService {
    
    @Autowired private ReviewRepository reviewRepository;
    @Autowired private ProductRepository productRepository;

    public List<ReviewDto> find(Integer bno){
        ProductEntity productEntity = productRepository.findById(bno).get();
        return productEntity.getReviewEntities().stream().map(ReviewDto::from).toList();
    }

    public boolean save(ReviewDto reviewDto) {
    ReviewEntity entity = reviewDto.toEntity();

    ProductEntity product = productRepository.findById(reviewDto.getBno()).orElse(null);
    entity.setProductEntity(product);

    reviewRepository.save(entity);
    if (entity.getRno() >= 1) {
        return true;
    }

    return false;
    }

    public boolean delete(Integer rno) {
        if(!reviewRepository.existsById(rno)){
            return false;
        }
        reviewRepository.deleteById(rno);
        return true;
    }
}