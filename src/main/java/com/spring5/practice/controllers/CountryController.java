package com.spring5.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring5.practice.model.Country;
import com.spring5.practice.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/country/add")
	public String addCountry_GET(Model model) {
		model.addAttribute("pageTitle", "Add Country");
		model.addAttribute("country", new Country());
		model.addAttribute("message", "Please add a country");
		return "country/add";
	}

	@PostMapping("/country/add")
	public String addCountry(Model model, @ModelAttribute(name = "country") Country country) {
		country.setActive(true);
		countryService.save(country);
		model.addAttribute("message", "Country added successfully");
		return "redirect:/country/show-all";
	}
	@GetMapping("/country/edit")
	public String updateCountry(Model model, @RequestParam("id") Long id){
		var country = countryService.findById(id);
		model.addAttribute("country", country);
		model.addAttribute("id", id);
		return "/country/edit";
	}
	@PostMapping("/country/edit")
	public String updateCountry(@ModelAttribute(name = "country") Country country){
		countryService.save(country);
		return "redirect:/country/show-all";
	}
	@GetMapping("/country/delete")
	public String deleteCountry(@RequestParam("id") Long id){
		countryService.delete(id);
		return "redirect:/country/show-all";
	}

	@GetMapping("/country/show-all")
	public String showAll_GET(Model model) {

		model.addAttribute("pageTitle", "Country List");
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("message", "Showing all countries");
		return "country/show-all";
	}


}
