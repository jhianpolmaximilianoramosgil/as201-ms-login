package com.javainfinite.security.controller;

import com.javainfinite.security.model.Person;
import com.javainfinite.security.model.User;
import com.javainfinite.security.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin("*")
@RequestMapping("/login")


public class UserController {

	private final UserService service;
	private final PasswordEncoder encoder;

	public UserController(UserService service, PasswordEncoder encoder) {
		this.service = service;
		this.encoder = encoder;
	}

	@GetMapping
	public List<User> findAll() {
		return service.findAll();
	}

	@GetMapping("/info/{username}")
    public User getStudentInfo(@PathVariable String username) {
        return service.getDetails(username);
    }

	@PostMapping("/user")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		User foundUser =  service.finByUserPassword(user.getSname(), user.getPassword());
		if (foundUser != null) {
			return ResponseEntity.ok(foundUser);
		} else {
			String errorMessage = "Usuario o contraseña incorrectos";
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"" + errorMessage + "\"}");
		}
	}

	@PostMapping("/create/user")
	public User registerStudent(@RequestBody User user) {
		user.setPassword(service.getSHA256(user.getPassword()));
		return service.registerStudent(user);
	}

	@PostMapping("/create/collaborator")
	public User registerCollaborator(@RequestBody User user) {
		user.setPassword(service.getSHA256(user.getPassword()));
		return service.registerCollaborator(user);
	}
}
