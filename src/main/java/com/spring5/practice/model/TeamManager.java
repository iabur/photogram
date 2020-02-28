package com.spring5.practice.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Where(clause = "is_active = 1")
@Table(name = "tbl_manager")
public class TeamManager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Manager_name", nullable = false)
    private String managerName;
    @Column(name = "Manager_Email", nullable = false)
    private String managerEmail;
    @ManyToOne
    @JoinColumn
    private Team team;
    @Column(name = "is_active")
    private Boolean active = true;

    public TeamManager() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "TeamManager{" +
                "id=" + id +
                ", managerName='" + managerName + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", team=" + team +
                ", active=" + active +
                '}';
    }
}
