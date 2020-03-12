package com.spring5.practice.dtos;

import com.spring5.practice.model.Post;
import com.spring5.practice.model.User;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDto implements Serializable {
    private Long id;
    private String comment;
    private Post post;
    private User user;
    private LocalDate commentTime;

    public CommentDto() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDate commentTime) {
        this.commentTime = commentTime;
    }
}
