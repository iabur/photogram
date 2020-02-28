package com.spring5.practice.repositories;

import com.spring5.practice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAll();
    String findByMemberName(String name);


}