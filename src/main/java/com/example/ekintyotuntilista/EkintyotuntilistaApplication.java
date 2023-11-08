package com.example.ekintyotuntilista;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ekintyotuntilista.domain.Hours;
import com.example.ekintyotuntilista.domain.HoursRepository;
import com.example.ekintyotuntilista.domain.JobDescription;
import com.example.ekintyotuntilista.domain.JobRepository;

import com.example.ekintyotuntilista.domain.AppUser;
import com.example.ekintyotuntilista.domain.AppUserRepository;

@SpringBootApplication
public class EkintyotuntilistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkintyotuntilistaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(JobRepository jrepository, HoursRepository hrepository, AppUserRepository urepository) {
		return (args) -> {

			jrepository.save(new JobDescription("Programming"));
			jrepository.save(new JobDescription("Consulting"));
			jrepository.save(new JobDescription("Sales"));
			jrepository.save(new JobDescription("Cleaning"));
				
			Hours h1 = new Hours(jrepository.findByJobname("Programming"), 16.0, 45.0);
			Hours h2 = new Hours(jrepository.findByJobname("Consulting"), 8.0, 35.0);
			Hours h3 = new Hours(jrepository.findByJobname("Sales"), 7.5, 14.0);
			Hours h4 = new Hours(jrepository.findByJobname("Cleaning"), 10.0, 11.0);
			hrepository.save(h1);
			hrepository.save(h2);
			hrepository.save(h3);
			hrepository.save(h4);
			
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			};
		};
	}

