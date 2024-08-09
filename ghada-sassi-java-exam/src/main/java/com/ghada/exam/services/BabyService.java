package com.ghada.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ghada.exam.models.Baby;
import com.ghada.exam.repositories.BabyRepository;

@Service
public class BabyService {

	@Autowired
	private BabyRepository babyRepository;

	// returns all the babys
	public List<Baby> allBabys() {
		return babyRepository.findAll();
	}

	// creates a baby
	public Baby createBaby(Baby baby, BindingResult result) {
		Optional<Baby> optionalBaby = babyRepository.findByBabyname(baby.getBabyname());
		if (optionalBaby.isPresent()) {
			result.rejectValue("babyname", "uniqueNameError", "This Name already exists!");
			
		}if (result.hasErrors()) {
			return null;
		}else {
			return babyRepository.save(baby);
		}
	}

	// retrieves a baby by id
	public Baby findBaby(Long id) {
		Optional<Baby> optionalBaby = babyRepository.findById(id);
		if (optionalBaby.isPresent()) {
			return optionalBaby.get();
		} else {
			return null;
		}
	}

	// Delete Baby
	public void deleteBaby(Long id) {
		babyRepository.deleteById(id);
	}

	// Edit Baby
	public Baby updateBaby(Baby baby) {
		return babyRepository.save(baby);

	}

}
