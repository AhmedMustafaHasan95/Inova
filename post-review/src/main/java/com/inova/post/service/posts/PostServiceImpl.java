package com.inova.post.service.posts;

import com.inova.post.DTO.PageDTO;
import com.inova.post.DTO.PostDTO;
import com.inova.post.entity.Post;
import com.inova.post.entity.User;
import com.inova.post.repository.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public PostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        post.setUser(new User(postDTO.getUserId()));
        postRepo.save(post);
        postDTO.setPostId(post.getPostId());
        return postDTO;
    }

    @Override
    @Transactional
    public PageDTO getUserPosts(PageDTO pageDTO) {
        Sort sort = Sort.by(Sort.Direction.ASC, "postId");
        Pageable pageable = PageRequest.of(pageDTO.getNumber() - 1, pageDTO.getSize(), sort);
        Page<Post> posts = postRepo.findAll(pageable);
        pageDTO.setAllSize(posts.getTotalElements());
        pageDTO.setData(posts.getContent());
        return pageDTO;
    }

    @Override
    @Transactional
    public PageDTO getTopPosts(PageDTO pageDTO) {
        return null;
    }
}
