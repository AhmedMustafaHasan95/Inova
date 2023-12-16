package com.inova.post.service.posts;

import com.inova.post.DTO.PageDTO;
import com.inova.post.DTO.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostService {
    public PostDTO createPost(PostDTO postDTO);

    public PageDTO getUserPosts(PageDTO pageDTO);

    public PageDTO getTopPosts(PageDTO pageDTO);
}
