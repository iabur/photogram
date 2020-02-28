package com.spring5.practice.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Where(clause = "is_active = 1")
@Table(name = "tbl_team")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Team_name", nullable = false, unique = true)
    private String teamName;
    @OneToOne
    @JoinColumn(name = "Country_id", nullable = false, unique = true)
    private Country country;
    @Column(name = "is_active")
    private Boolean active = true;


    public Team() {
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", country=" + country +
                '}';
    }
}
