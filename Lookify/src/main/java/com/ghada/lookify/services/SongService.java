package com.ghada.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghada.lookify.models.Song;
import com.ghada.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;

	// READ ALL
	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	// CREATE
	public Song createSong(Song song) {
		return songRepository.save(song);
	}

	// retrieves a Song
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);

		return optionalSong.isPresent() ? optionalSong.get() : null;

	}

	// Update a Song
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}

	// DELETE a Song
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}

	// Search by artist
	public List<Song> artistsSongs(String artist) {
		return songRepository.findByArtist(artist);
	}
	
	// Top Ten Songs
		public List<Song> topTen() {
			return songRepository.findTop10ByOrderByRatingDesc();
		}

}
