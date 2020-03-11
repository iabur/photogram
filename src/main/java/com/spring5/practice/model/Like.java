package com.spring5.practice.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tbl_like")
public class Like implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="is_active", nullable = true)
    private Boolean active;
    @ManyToOne
    @JoinColumn
    private Post post;

    public Like() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
