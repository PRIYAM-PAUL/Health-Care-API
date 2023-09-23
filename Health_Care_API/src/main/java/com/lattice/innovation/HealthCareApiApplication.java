package com.lattice.innovation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "Health Care API" ,
			version = "1.0.0",
			description = "An API project given by Lattice innovation",
			termsOfService = "nothing",
			contact = @Contact(
					email = "priyampaul106@gmail.com",
					name = "Priyam Paul"
					
					),
			license = @License(
					name = "Apache License Version 2.0",
					url = "https://www.apache.org/licenses/LICENSE-2.0"
					)
			
			)
		)

public class HealthCareApiApplication  {
	
	public static void main(String[] args) {
		
	    
		SpringApplication.run(HealthCareApiApplication.class, args);
		
	}
}
