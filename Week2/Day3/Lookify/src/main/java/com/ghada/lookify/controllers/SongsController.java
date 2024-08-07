package com.ghada.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ghada.lookify.models.Song;
import com.ghada.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongsController {

	@Autowired
	private SongService songService;

	//Home ===Display route ===
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}

	//Dashboard ===Display route ===
	@GetMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("artist") String artist) {
		List<Song> allSongs = songService.allSongs();
		model.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";
	}

	// Create a Song === Display ROUTE ===
	@GetMapping("/songs/new")
	public String create(@ModelAttribute("song") Song song) {
		return "create.jsp";
	}

	// Create a Song === ACTION ROUTE ==== REDIRECT
	@PostMapping("/songs")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	// DELETE
	@DeleteMapping("/songs/{id}")
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

	// SHOW ONE
	@GetMapping("/songs/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Song thisSong = songService.findSong(id);
		model.addAttribute("song", thisSong);
		return "show.jsp";
	}

	// Search by artist ===Display Route===
	@GetMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {

		List<Song> artistSongs = songService.artistsSongs(artist);
		model.addAttribute("artistSongs", artistSongs);
		return "search.jsp";

	}

	// Search by artist ===Action Route==== REDIRECT
	@PostMapping("/search")
	public String searchArtistSongs(@RequestParam String artist, Model model) {

		model.addAttribute("artist", artist);
		return "redirect:/search/" + artist;

	}
	
//Top 10 Songs ===Display Route===
	@GetMapping("/songs/top-ten")
	public String topTen(Model model) {
		List<Song> topTenSongs = songService.topTen();
		model.addAttribute("topTenSongs", topTenSongs);
		return "topTen.jsp";
	}

}
