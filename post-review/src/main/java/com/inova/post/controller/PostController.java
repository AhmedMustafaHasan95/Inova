package com.inova.post.controller;

import com.inova.post.DTO.PageDTO;
import com.inova.post.DTO.PostDTO;
import com.inova.post.DTO.UserDTO;
import com.inova.post.service.posts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/Posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity createPost(@RequestBody PostDTO postDTO) {
        try {
            postService.createPost(postDTO);
            return ResponseEntity.ok(postDTO);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/getUserPosts")
    public ResponseEntity getUserPosts(@RequestBody PageDTO pageDTO) {
        try {
            postService.getUserPosts(pageDTO);
            return ResponseEntity.ok(pageDTO);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/getTopPosts")
    public ResponseEntity getTopPosts(@RequestBody @Valid PageDTO pageDTO) {
        try {
            postService.getTopPosts(pageDTO);
            return ResponseEntity.ok(pageDTO);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
