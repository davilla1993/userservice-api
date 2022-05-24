package com.follydev.userservice;

import com.follydev.userservice.domain.AppUser;
import com.follydev.userservice.domain.Role;
import com.follydev.userservice.services.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserServices userServices){
		return args -> {
			userServices.saveRole(new Role(null, "ROLE_USER"));
			userServices.saveRole(new Role(null, "ROLE_MANAGER"));
			userServices.saveRole(new Role(null, "ROLE_ADMIN"));
			userServices.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userServices.saveUser(new AppUser(null, "John Travolta", "john", "123456", new ArrayList<>()));
			userServices.saveUser(new AppUser(null, "Will Smith", "will", "123456", new ArrayList<>()));
			userServices.saveUser(new AppUser(null, "Alex ADJEI", "alex", "123456", new ArrayList<>()));
			userServices.saveUser(new AppUser(null, "Carlo GBOSSOU", "carlo", "123456", new ArrayList<>()));
			userServices.saveUser(new AppUser(null, "Fabio KOSSI", "fabio", "123456", new ArrayList<>()));

			userServices.addRoleToUser("john", "ROLE_USER");
			userServices.addRoleToUser("john", "ROLE_MANAGER");
			userServices.addRoleToUser("will", "ROLE_ADMIN");
			userServices.addRoleToUser("carlo", "ROLE_SUPER_ADMIN");
			userServices.addRoleToUser("carlo", "ROLE_ADMIN");
			userServices.addRoleToUser("alex", "ROLE_USER");
			userServices.addRoleToUser("alex", "ROLE_MANAGER");
			userServices.addRoleToUser("fabio", "ROLE_USER");
			userServices.addRoleToUser("fabio", "ROLE_ADMIN");
			userServices.addRoleToUser("will", "ROLE_USER");


		};
	}

}


