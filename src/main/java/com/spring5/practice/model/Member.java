package com.spring5.practice.model;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Where(clause = "is_active = 1")
@Table(name = "tbl_member")
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Member_name", nullable = false)
    private String memberName;
    @Column(name = "Member_Email", nullable = false)
    private String memberEmail;
    @Column(name = "Birth_data", nullable = true)
   private LocalDate dob;
    @Column(name = "age")
    private int memberAge;
    @ManyToOne
    @JoinColumn
    private Team team;
    @Column(name = "is_active")
    private Boolean active = true;
    @Column(name = "role")
    private String role;



    public Member() {
    }

    public String getRole() {
        return role;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }
    public LocalDate getDob() {
        return dob;
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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }



    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", dob=" + dob +
                ", memberAge=" + memberAge +
                ", team=" + team +
                ", active=" + active +
                ", role='" + role + '\'' +
                '}';
    }
}
