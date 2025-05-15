package com.kornel.progtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.kornel.progtech.model.Role;
import com.kornel.progtech.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProgtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgtechApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.count() == 0) {
				roleRepository.save(new Role(null, "ROLE_ADMIN", null));
				roleRepository.save(new Role(null, "ROLE_USER", null));
			}
		};
	}

}
