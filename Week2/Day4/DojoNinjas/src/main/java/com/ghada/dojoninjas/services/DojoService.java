package com.ghada.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghada.dojoninjas.models.Dojo;
import com.ghada.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository;

	// READ ALL
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	// CREATE
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	// retrieves a Dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);

		return optionalDojo.isPresent() ? optionalDojo.get() : null;

	}

	// Update a Dojo
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	// DELETE a Dojo
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}

}
