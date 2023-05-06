package com.team.forum.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.forum.models.Theme;
import com.team.forum.repositories.ThemeRepository;

@Service
public class ThemeService {

	// adding the theme repository as a dependency using @Autowired
	@Autowired
	private ThemeRepository themeRepository;

	// READ ALL
	public List<Theme> allThemes() {
		return themeRepository.findAll();
	}

	// CREATE
	public Theme createTheme(Theme theme) {
		return themeRepository.save(theme);
	}

	// retrieves a theme
	public Theme findTheme(Long id) {
		Optional<Theme> optionalTheme = themeRepository.findById(id);

		return optionalTheme.isPresent() ? optionalTheme.get() : null;

	}

	// Update a Theme
	public Theme updateTheme(Long id, Theme theme) {
		theme.setId(id);
		return themeRepository.save(theme);
	}

	// DELETE a Theme
	public void deleteTheme(Long id) {
		themeRepository.deleteById(id);
	}

	// READ ALL themes order by themeName
	public List<Theme> allThemesOrderedByThemeName() {
		return themeRepository.findByOrderByThemeNameAsc();
	}

	// Search by themeName
	public List<Theme> searchByThemeName(String themeName) {
		return themeRepository.findByThemeName(themeName);
	}

}
