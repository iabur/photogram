package com.spring5.practice.service;

import com.spring5.practice.dtos.MemberDto;
import com.spring5.practice.enums.Role;
import com.spring5.practice.exceptions.ResourceNotFoundException;
import com.spring5.practice.model.Member;
import com.spring5.practice.model.Team;
import com.spring5.practice.model.User;
import com.spring5.practice.repositories.ManagerRepository;
import com.spring5.practice.repositories.MemberRepository;
import com.spring5.practice.repositories.TeamRepository;
import com.spring5.practice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public void save(MemberDto memberDto, String userName){
        //var userName = authentication.getName();
        var team = managerRepository.findByManagerName(userName).getTeam();
        var member = new Member();
        var user = new User();
        memberCombine(memberDto, member, team, user);
    }

    private void memberCombine(MemberDto memberDto, Member member, Team team, User user) {
        member.setMemberName(memberDto.getMemberName());
        member.setMemberEmail(memberDto.getMemberEmail());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Period age = Period.between(LocalDate.parse(memberDto.getDob(), dateTimeFormatter), LocalDate.now());
        member.setDob(LocalDate.parse(memberDto.getDob(), dateTimeFormatter));
        member.setMemberAge(age.getYears());
        member.setRole(memberDto.getRole());
        member.setTeam(team);
        memberRepository.save(member);

        user.setUsername(memberDto.getMemberName());
        user.setPassword(passwordEncoder.encode("player"));
        user.setRole(Role.ROLE_PLAYER);
        userRepository.save(user);
    }

    public void saveEdit(MemberDto memberDto)
    {
        //var team = teamRepository.findById(memberDto.getTeamId()).get();
        Member member = memberRepository.findById(memberDto.getMemberId()).get();
        var team = member.getTeam();
        var userName = member.getMemberName();
        var user = userRepository.findByUsername(userName).get();
        memberCombine(memberDto, member, team, user);
    }

    public List<Member> getAll(){
        var members = memberRepository.findAll();
        if(members.size() == 0)
        {
            throw new ResourceNotFoundException("No member found");
        }
      return  memberRepository.findAll();
    }
    public void delete(Long id)
    {
       var member =  memberRepository.findById(id).get();
       member.setActive(false);
       memberRepository.save(member);
    }
    public Optional<Member> findById(Long id)
    {
        return memberRepository.findById(id);
    }

}
