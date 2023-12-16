package com.inova.post.controller;


import com.inova.post.DTO.ReviewDTO;
import com.inova.post.service.posts.PostService;
import com.inova.post.service.reviews.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Reviews")
public class ReviewController {
    @Autowired
    private ReviewService postService;

    @PostMapping("/createReview")
    public ResponseEntity createReview(@RequestBody ReviewDTO reviewDTO) {
        try {
            postService.createReview(reviewDTO);
            return ResponseEntity.ok(reviewDTO);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
