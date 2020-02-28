package com.spring5.practice.repositories;
import com.spring5.practice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository

@Transactional

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByTeamName(String name);
    List<Team> findAll();
}