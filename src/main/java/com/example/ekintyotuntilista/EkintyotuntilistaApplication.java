package com.example.ekintyotuntilista;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ekintyotuntilista.domain.Hours;
import com.example.ekintyotuntilista.domain.HoursRepository;
import com.example.ekintyotuntilista.domain.AppUser;
import com.example.ekintyotuntilista.domain.UserRepository;

@SpringBootApplication
public class EkintyotuntilistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkintyotuntilistaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository urepository, HoursRepository hrepository) {
		return (args) -> {

			urepository.save(new AppUser("Pekka"));
			urepository.save(new AppUser("Taavi"));

				
			Hours h1 = new Hours(urepository.findByUsername("Pekka"), 8.0, 45.0);
			Hours h2 = new Hours(urepository.findByUsername("Taavi"), 8.0, 45.0);
			hrepository.save(h1);
			hrepository.save(h2);
		};
	}
}
