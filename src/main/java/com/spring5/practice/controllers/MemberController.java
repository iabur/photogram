package com.spring5.practice.controllers;

import com.spring5.practice.dtos.MemberDto;
import com.spring5.practice.exceptions.ResourceNotFoundException;
import com.spring5.practice.model.Member;
import com.spring5.practice.service.MemberService;
import com.spring5.practice.service.TeamService;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/member/add")
    public String addMember(Model model){

        model.addAttribute("member", new MemberDto());
        model.addAttribute("teams", teamService.getAllTeam());
        return "member/add";
    }

    @PostMapping("/member/add")
    public String addMember(Model model, @ModelAttribute(name = "member")MemberDto memberDto, Authentication authentication){
       var userName = authentication.getName();
        memberService.save(memberDto, userName);
       // return "Redirect:/member/show-all";
        return "redirect:/member/show-all";
    }

    @GetMapping("/member/edit")
    public String editMember(Model model, @RequestParam(name = "id") Long id){
        model.addAttribute("member", new MemberDto());
        model.addAttribute("id", id);
        return "member/edit";
    }

    @PostMapping("/member/edit")
    public String editMember(Model model, @ModelAttribute(name = "member") MemberDto memberDto){
        memberService.saveEdit(memberDto);
        return "redirect:/member/show-all";
    }

    @GetMapping("/member/delete")
    public String deleteMember(@RequestParam("id") Long id){
        memberService.delete(id);
        return "redirect:/member/show-all";
    }


    @GetMapping("/member/show-all")
    public String showAllMembers(Model model){
        model.addAttribute("members", memberService.getAll());
        return "/member/show-all";
    }
    @GetMapping(value = "/search-page")

    public String searchCourseView(Model model) {

        return "/member/search";

    }
}

