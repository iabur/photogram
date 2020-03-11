package com.spring5.practice.repositories;

import com.spring5.practice.model.Like;
import com.spring5.practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findById(Long id);
}
