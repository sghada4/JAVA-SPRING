package com.ghada.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghada.dojoninjas.models.Ninja;
import com.ghada.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepository;

	// READ ALL
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}

	// CREATE
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	// retrieves a Ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);

		return optionalNinja.isPresent() ? optionalNinja.get() : null;

	}

	// Update a Ninja
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	// DELETE a Ninja
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}

}
