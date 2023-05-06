package com.team.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.forum.models.Theme;
import com.team.forum.services.ThemeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ThemeApi {

	@Autowired
	private ThemeService themeService;

	// READ ALL
	@GetMapping("/themes")
	public List<Theme> allThemes() {
		return themeService.allThemes();
	}

	// CREATE
	@PostMapping("/themes")
	public Theme createTheme(@RequestBody Theme theme) {
		return themeService.createTheme(theme);
	}

	// READ ONE
	@GetMapping("/themes/{id}")
	public Theme showTheme(@PathVariable("id") Long id) {

		return themeService.findTheme(id);
	}

	// UPDATE

	@PutMapping("/themes/{id}")
	public Theme updateTheme(@PathVariable("id") Long id, @RequestBody Theme theme) {

		return themeService.updateTheme(id, theme);
	}

	// DELETE
	@DeleteMapping("/themes/{id}")
	public void destroy(@PathVariable("id") Long id) {
		themeService.deleteTheme(id);
	}

	// Search By themeName
	@PostMapping("/themes/search")
	public List<Theme> searchTheme(@RequestBody Theme theme) {
		return themeService.searchByThemeName(theme.getThemeName());
	}

}
