package com.example.ekintyotuntilista.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ekintyotuntilista.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository urepository;

	public UserRepository getUrepository() {
		return urepository;
	}

	public void setUrepository(UserRepository urepository) {
		this.urepository = urepository;
	}

}
