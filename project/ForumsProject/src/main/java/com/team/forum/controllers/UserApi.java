package com.team.forum.controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.forum.models.User;
import com.team.forum.services.UserService;

import jakarta.validation.ValidationException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserApi {

	@Autowired
	private UserService userService;

	// Api Registration
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User newUser) {
		String tempEmail = newUser.getEmail();
		String tempPassword = newUser.getPassword();

		if (tempEmail == null || "".equals(tempEmail)) {
			return ResponseEntity.badRequest().body("Email is required");
		} else {
			User user = userService.findUser(tempEmail);
			if (user != null) {
				return ResponseEntity.badRequest().body("Email already exists!");
			}

		}

		if (tempPassword == null || "".equals(tempPassword)) {
			return ResponseEntity.badRequest().body("Password is required");
		} else {
			String hashedPassword = BCrypt.hashpw(tempPassword, BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
		}

		try {
			User user = userService.createUser(newUser);
			return ResponseEntity.ok(user);
		} catch (ValidationException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	// Api Login
	@PostMapping("/login")
	public User loginUser(@RequestBody User newLogin) throws Exception {
		String tempEmail = newLogin.getEmail();
		String tempPass = newLogin.getPassword();
		User userObj = null;
		if (tempEmail != null && tempPass != null) {
			userObj = userService.findUser(tempEmail);
			if (userObj == null) {
				throw new Exception("Invalid Credentials!");
			} else {
				if (!BCrypt.checkpw(newLogin.getPassword(), userObj.getPassword())) {
					throw new Exception("Invalid Credentials!");
				}
			}
		}

		return userObj;
	}

	// READ ONE
	@GetMapping("/user/{id}")
	public User showUser(@PathVariable("id") Long id) {

		return userService.findUserById(id);
	}
	
	@GetMapping("/users")
	public List<User> allUsers() {

		return userService.allUsers();
	}

}
