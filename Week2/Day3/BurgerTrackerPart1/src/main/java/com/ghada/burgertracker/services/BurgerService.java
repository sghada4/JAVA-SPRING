package com.ghada.burgertracker.services;

import java.util.List;

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
       
}
