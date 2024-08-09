package com.ghada.exam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ghada.exam.models.Baby;

@Repository
public interface BabyRepository extends CrudRepository<Baby, Long> {

	List<Baby> findAll();

	Optional<Baby> findByBabyname(String babyname);
}
