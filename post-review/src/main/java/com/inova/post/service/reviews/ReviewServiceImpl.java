package com.inova.post.service.reviews;

import com.inova.post.DTO.ReviewDTO;
import com.inova.post.entity.Post;
import com.inova.post.entity.Review;
import com.inova.post.entity.User;
import com.inova.post.repository.PostRepo;
import com.inova.post.repository.ReviewRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public ReviewDTO createReview(ReviewDTO dto) {
        Review review = modelMapper.map(dto, Review.class);
        Post post = postRepo.findById(dto.getPostId()).get();
        List<Review> postReviews = new ArrayList<>();
        postReviews.addAll(post.getReviews());
        postReviews.add(review);
        postReviews.removeIf(Objects::isNull);
        double rate = postReviews.stream().mapToDouble(r -> r.getRate() != null ? r.getRate() : 0).average().getAsDouble();
        post.setRate((float) rate);
        review.setUser(new User(dto.getUserId()));
        review.setPost(new Post(dto.getPostId()));
        dto.setReviewId(review.getReviewId());
        reviewRepo.save(review);
        reviewRepo.flush();
        postRepo.save(post);
        return dto;
    }


}
