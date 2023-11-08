package com.example.ekintyotuntilista.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ekintyotuntilista.domain.HoursRepository;
import com.example.ekintyotuntilista.domain.JobRepository;

@Controller
public class HoursController {
	
	@Autowired
	private HoursRepository hrepository;
	
	@Autowired
	private JobRepository jrepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }

	@GetMapping("/hourslist")
	public String hourslist(Model model) {
		model.addAttribute("hours", hrepository.findAll());
		return "hourslist";
	}
}
