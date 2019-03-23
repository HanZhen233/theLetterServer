package com.hanzhen.theletterserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheletterserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheletterserverApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner demo(UserRepository userRepository, RoleRepository roleResposity) {
//		return (args) -> {
//			Role role=roleResposity.findById(2);
//			List<Role> roles= new ArrayList<>();
//			roles.add(role);
//			User user=new User("haha","123456","123",0,roles);
//			userRepository.save(user);
//		};
//	}
}
