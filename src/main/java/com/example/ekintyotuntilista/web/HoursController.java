package com.example.ekintyotuntilista.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ekintyotuntilista.domain.HoursRepository;

@Controller
public class HoursController {
	
	@Autowired
	private HoursRepository hrepository;

	@GetMapping("/hourslist")
	public String hourslist(Model model) {
		model.addAttribute("hours", hrepository.findAll());
		return "hourslist";
	}
}
