package com.spring5.practice.repositories;

import com.spring5.practice.model.TeamManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ManagerRepository extends JpaRepository<TeamManager, Long> {
    TeamManager findByManagerName(String name);
}
