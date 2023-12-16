package com.inova.post.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REVIEW")
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "REVIEW_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    @Column(name = "RATE")
    private Short rate;
    @Basic(optional = false)
    @Column(name = "COMMENT",nullable = false)
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Review() {
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public Short getRate() {
        return rate;
    }

    public void setRate(Short rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
