package com.demo.backend;

import com.demo.backend.model.ERole;
import com.demo.backend.model.PersonEntity;
import com.demo.backend.model.RoleEntity;
import com.demo.backend.model.UserEntity;
import com.demo.backend.repositories.PersonRepository;
import com.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


}


