package com.spring5.practice.requestModel;

import com.spring5.practice.model.Post;
import com.spring5.practice.model.User;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentRequestModel implements Serializable {
    private Long id;
    private String comment;
    private Post post;
    private Long postId;
    private User user;
    private Long userId;
    private LocalDate commentTime;

    public CommentRequestModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDate commentTime) {
        this.commentTime = commentTime;
    }
}
