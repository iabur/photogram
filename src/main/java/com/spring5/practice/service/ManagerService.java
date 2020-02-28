package com.spring5.practice.service;

import com.spring5.practice.dtos.MemberDto;
import com.spring5.practice.enums.Role;
import com.spring5.practice.exceptions.ResourceNotFoundException;
import com.spring5.practice.model.Member;
import com.spring5.practice.model.Team;
import com.spring5.practice.model.TeamManager;
import com.spring5.practice.model.User;
import com.spring5.practice.repositories.ManagerRepository;
import com.spring5.practice.repositories.TeamRepository;
import com.spring5.practice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManagerService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(MemberDto memberDto){
        var team = teamRepository.findById(memberDto.getTeamId()).get();
        var manager = new TeamManager();
        var user = new User();
        memberCombine(memberDto, manager, team, user);

    }

    private void memberCombine(MemberDto memberDto, TeamManager manager, Team team, User user) {
        manager.setManagerName(memberDto.getMemberName());
        manager.setManagerEmail(memberDto.getMemberEmail());
        manager.setTeam(team);
        managerRepository.save(manager);


        user.setUsername(memberDto.getMemberName());
        user.setPassword(passwordEncoder.encode("manager"));
        user.setRole(Role.ROLE_MANAGER);
        userRepository.save(user);
    }

    public void saveEdit(MemberDto memberDto)
    {
        var team = teamRepository.findById(memberDto.getTeamId()).get();
        var manager = managerRepository.findById(memberDto.getMemberId()).get();
        var managerName = manager.getManagerName();
        var user = userRepository.findByUsername(managerName).get();
        memberCombine(memberDto, manager, team, user);
    }

    public List<TeamManager> getAll(){
        var managers = managerRepository.findAll();
        if(managers.size() == 0)
        {
            throw new ResourceNotFoundException("No managers found");
        }
        return  managerRepository.findAll();
    }
    public void delete(Long id)
    {
        var manager =  managerRepository.findById(id).get();
        manager.setActive(false);
        managerRepository.save(manager);
    }
    public Optional<TeamManager> findById(Long id)
    {
        return managerRepository.findById(id);
    }
    public TeamManager findByName(String name){
        return managerRepository.findByManagerName(name);
    }
}
