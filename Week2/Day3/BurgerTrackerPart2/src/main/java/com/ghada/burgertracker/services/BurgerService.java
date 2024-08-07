package com.ghada.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghada.burgertracker.models.Burger;
import com.ghada.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	@Autowired
	private BurgerRepository burgerRepository;

	// READ ALL
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}

	// CREATE
	public Burger createBurger(Burger b) {
		return burgerRepository.save(b);
	}

	// retrieves a Burger
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);

		return optionalBurger.isPresent() ? optionalBurger.get() : null;

	}

	// Update a Burger
	public Burger updateBurger(Burger b) {
		return burgerRepository.save(b);
	}
}
