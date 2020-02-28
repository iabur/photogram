package com.spring5.practice.controllers;

import com.spring5.practice.dtos.TeamDto;

import com.spring5.practice.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import com.spring5.practice.service.CountryService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class TeamController {


    @Autowired

    private CountryService countryService;

    @Autowired
    private TeamService teamService;


    @GetMapping("/team/add")

    public String addTeam_GET(Model model) {

        model.addAttribute("team", new TeamDto());

        model.addAttribute("countries", countryService.findAll());

        model.addAttribute("message", "Please add a Team");

        return "team/add";

    }


    @PostMapping("/team/add")

    public String addTeam(Model model, @ModelAttribute(name = "team") TeamDto teamDto) {

        teamService.save(teamDto);
        model.addAttribute("message", "Team added successfully");

        return "redirect:/team/show-all";
    }

    @GetMapping("/team/edit")
    public String editTeam(Model model, @RequestParam("id") Long id){
        model.addAttribute("teamDto", new TeamDto());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("id", id);
        return "/team/edit";
    }
    @PostMapping("/team/edit")
    public String editTeam(Model model, @ModelAttribute(name = "teamDto") TeamDto teamDto){
        teamService.saveEdit(teamDto);
        return "redirect:/team/show-all";
    }
    @GetMapping("/team/delete")
    public String deleteTeam(@RequestParam("id") Long id){
        teamService.deleteTeam(id);
        return "redirect:/team/show-all";
    }


    @GetMapping("/team/show-all")

    public String showAll_GET(Model model) {

        model.addAttribute("pageTitle", "Team List");

        model.addAttribute("teams", teamService.getAllTeam());

        //model.addAttribute("countries", countryService.getAllCountry());

        model.addAttribute("message", "Showing all teams");

        return "team/show-all";

    }

/*

	@GetMapping("/country/show/{code}")

	public String showAll_GET(@PathVariable(name = "code") String code, Model model) {

		model.addAttribute("country", countryService.getCountryByCode(code));

		model.addAttribute("message", "Showing country with code");

		return "country/show-by-code";

	}
*/

}



