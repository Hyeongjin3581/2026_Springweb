package example.totalpractice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.totalpractice1.model.dto.ReviewDto;
import example.totalpractice1.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")

public class ReviewController {
    @Autowired private ReviewService reviewService;

    @GetMapping("")
    public List<ReviewDto> find(@RequestParam(name="bno") Integer bno){
        return reviewService.find(bno);
    }

    @PostMapping("")
    public boolean save(@RequestBody ReviewDto reviewDto){
        return reviewService.save(reviewDto);
    }

    @DeleteMapping("")
    public boolean delete(@RequestParam(name="rno") Integer rno){
        return reviewService.delete(rno);
    }
}