package com.example.ekintyotuntilista.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HoursController {

	@GetMapping("/hourslist")
	public String hourslist(Model model) {
		return "hourslist";
	}
}
