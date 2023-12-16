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
    public ResponseEntity<PostDTO> cr(@RequestBody PostDTO postDTO) {
        postService.createPost(postDTO);
        return ResponseEntity.ok(postDTO);
    }
    @PostMapping("/getUserPosts")
    public ResponseEntity<PageDTO> getUserPosts(@RequestBody PageDTO pageDTO) {
        postService.getUserPosts(pageDTO);
        return ResponseEntity.ok(pageDTO);
    }
    @PostMapping("/getTopPosts")
    public ResponseEntity<PageDTO> getTopPosts(@RequestBody @Valid PageDTO pageDTO) {
        postService.getTopPosts(pageDTO);
        return ResponseEntity.ok(pageDTO);
    }
}
