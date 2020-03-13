package com.spring5.practice.dtos;

import com.spring5.practice.model.Comment;
import com.spring5.practice.model.Like;
import com.spring5.practice.model.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class PostDto implements Serializable {
    private Long id;
    private String caption;
    private List<String> images;
    private User user;
    private List<Comment> comments;
    private List<Like> likes;
    private LocalDate postTime;
    private String postTimeString;
    private Long totalLike;
    private Long totalComment;
    private Boolean isliked;

    public PostDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public LocalDate getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDate postTime) {
        this.postTime = postTime;
    }

    public String getPostTimeString() {
        return postTimeString;
    }

    public void setPostTimeString(String postTimeString) {
        this.postTimeString = postTimeString;
    }

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long totalLike) {
        this.totalLike = totalLike;
    }

    public Long getTotalComment() {
        return totalComment;
    }

    public void setTotalComment(Long totalComment) {
        this.totalComment = totalComment;
    }

    public Boolean getIsliked() {
        return isliked;
    }

    public void setIsliked(Boolean isliked) {
        this.isliked = isliked;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", images=" + images +
                ", user=" + user +
                ", comments=" + comments +
                ", likes=" + likes +
                ", postTime=" + postTime +
                ", postTimeString='" + postTimeString + '\'' +
                ", totalLike=" + totalLike +
                ", totalComment=" + totalComment +
                ", isliked=" + isliked +
                '}';
    }
}
