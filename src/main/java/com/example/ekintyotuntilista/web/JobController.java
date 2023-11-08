package com.example.ekintyotuntilista.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ekintyotuntilista.domain.JobRepository;

@Controller
public class JobController {
	
	@Autowired
	private JobRepository jrepository;

	public JobRepository getJrepository() {
		return jrepository;
	}

	public void setUrepository(JobRepository jrepository) {
		this.jrepository = jrepository;
	}

}
