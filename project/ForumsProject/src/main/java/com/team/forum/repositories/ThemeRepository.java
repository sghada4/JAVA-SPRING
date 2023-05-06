package com.team.forum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.forum.models.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

	List<Theme> findAll();

}
