package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InternManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternManagementBackendApplication.class, args);
	}

  

	// @Bean
	// public CommandLineRunner run(UserService userService) throws Exception {
	// 	return args -> {
	// 		userService.saveRole(new Role(new Random().nextLong(), "ROLE_USER"));
	// 		userService.saveRole(new Role(new Random().nextLong(), "ROLE_FACULTY"));
	// 		userService.saveRole(new Role(new Random().nextLong(), "ROLE_ADMIN"));

	// 		userService.saveUser(new UserModel(new Random().nextLong(), "John", "Travolta", "travoltaj", "1234", new ArrayList<>()));
	// 		userService.saveUser(new UserModel(new Random().nextLong(), "Will", "Smith", "smithw", "1234", new ArrayList<>()));
	// 		userService.saveUser(new UserModel(new Random().nextLong(), "Jim", "Carry", "carryj", "1234", new ArrayList<>()));
	// 		userService.saveUser(new UserModel(new Random().nextLong(), "Ryan", "Reynolds", "reynoldsr", "1234", new ArrayList<>()));

	// 		userService.addRoleToUser("travoltaj", "ROLE_USER");
	// 		userService.addRoleToUser("smithw", "ROLE_FACULTY");
	// 		userService.addRoleToUser("carryj", "ROLE_ADMIN");
	// 		userService.addRoleToUser("carryj", "ROLE_USER");
	// 		userService.addRoleToUser("carryj", "ROLE_FACULTY");
	// 		userService.addRoleToUser("reynoldsr", "ROLE_USER");
	// 	};
	// }


}
