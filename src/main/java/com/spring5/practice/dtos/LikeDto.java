package com.spring5.practice.dtos;

import com.spring5.practice.model.Post;
import com.spring5.practice.model.User;

import java.io.Serializable;

public class LikeDto implements Serializable {
    private Long id;
    private Post post;
    private User user;

    public LikeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
