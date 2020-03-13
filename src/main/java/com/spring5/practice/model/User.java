package com.spring5.practice.model;

import com.spring5.practice.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password", length = 512)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Column(name = "photo", nullable = true)
    private String photo;
    @Column(name = "email")
    private String Email;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "about")
    private String about;
    @Column(name = "phone")
    private String phone;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "createdAt", updatable = true, nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt", updatable = true, nullable = true)
    private LocalDateTime updatedAt;

    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name = "following")
    private List<Long> following =  new ArrayList<>();

    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name = "followed_by")
    private List<Long> followedBy =  new ArrayList<>();



    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Long> getFollowing() {
        return following;
    }

    public void setFollowing(List<Long> following) {
        this.following = following;
    }

    public List<Long> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(List<Long> followedBy) {
        this.followedBy = followedBy;
    }
}
