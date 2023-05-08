package com.team.forum.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.forum.models.User;
import com.team.forum.repositories.UserRepository;

@Service
public class UserService {

	// adding the theme repository as a dependency using @Autowired
	@Autowired
	private UserRepository userRepository;

	// CREATE
	public User createUser(User user) {
		return userRepository.save(user);
	}

	// retrieves a user by email
	public User findUser(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);

		return optionalUser.isPresent() ? optionalUser.get() : null;

	}

	// retrieves a user by id
	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);

		return optionalUser.isPresent() ? optionalUser.get() : null;

	}
}
