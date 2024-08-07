package com.ghada.loginregistration.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ghada.loginregistration.models.LoginUser;
import com.ghada.loginregistration.models.User;
import com.ghada.loginregistration.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Register Method
	public User register(User newUser, BindingResult result) {
		// check if user exists ?
		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			//rejectValue is used to add errors in the result object
			result.rejectValue("email", "registrationError", "This Email is already Taken!");
		}
		// Check if passwords matches
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registrationError", "Passwords must match !");
		}
		if (result.hasErrors()) {
			//if we have errors we should not return null 
			return null;
		} else {
			// hash the password
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			// intercept the user object to store the hashed password instead of plain-text
			newUser.setPassword(hashed);
			// save user to the Database
			return userRepository.save(newUser);
		}
	}

	//Login method
	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "Invalid fields");
		} else {
			//we should get the user from the database to use it
			User user = potentialUser.get();
			// BCRYPT check password
			if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				result.rejectValue("password", "loginError", "Invalid fields !");
			}
			if (result.hasErrors()) {
				return null;
			} else {
				return user;
			}

		}
		return null;
	}

	// READ ALL
	//is used in the admin part
	public List<User> allUsers() {
		return userRepository.findAll();
	}

	// READ ONE user by id
	public User findOne(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}
}