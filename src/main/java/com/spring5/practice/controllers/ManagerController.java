package com.spring5.practice.controllers;

import com.spring5.practice.dtos.MemberDto;
import com.spring5.practice.repositories.UserRepository;
import com.spring5.practice.service.ManagerService;
import com.spring5.practice.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/teamManager/add")
    public String addManager(Model model){
        model.addAttribute("member", new MemberDto());
        model.addAttribute("teams", teamService.getAllTeam());
        return "teamManager/add";
    }

    @PostMapping("/teamManager/add")
    public String addManager(Model model, @ModelAttribute(name = "member")MemberDto memberDto){
        managerService.save(memberDto);
        // return "Redirect:/member/show-all";
        return "redirect:/teamManager/show-all";
    }

    @GetMapping("/teamManager/edit")
    public String editManager(Model model, @RequestParam(name = "managerId") Long managerId){
        model.addAttribute("member", new MemberDto());
        model.addAttribute("managerId", managerId);
        model.addAttribute("teams", teamService.getAllTeam());
        return "teamManager/edit";
    }

    @PostMapping("/teamManager/edit")
    public String editManager(Model model, @ModelAttribute(name = "member") MemberDto memberDto){
        managerService.saveEdit(memberDto);
        return "redirect:/teamManager/show-all";
    }

    @GetMapping("/teamManager/delete")
    public String deleteManager(@RequestParam("id") Long id){
        managerService.delete(id);
        return "redirect:/teamManager/show-all";
    }


    @GetMapping("/teamManager/show-all")
    public String showAllManager(Model model){
        model.addAttribute("managers", managerService.getAll());
        return "/teamManager/show-all";
    }


}
