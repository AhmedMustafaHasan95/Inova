package com.inova.post.DTO;

import com.inova.post.entity.Review;
import com.inova.post.entity.User;

import javax.persistence.*;
import java.util.List;

public class PostDTO {
    private long postId;
    private String title;
    private String body;
    private Long userId;

    public PostDTO() {
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
