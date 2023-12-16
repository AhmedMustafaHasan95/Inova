package com.inova.post.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "POST")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "POST_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "BODY", nullable = false)
    private String body;
    @Column(name = "AVG_RATE", nullable = false)
    private float rate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Post() {
    }

    public Post(long postId) {
        this.postId = postId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}