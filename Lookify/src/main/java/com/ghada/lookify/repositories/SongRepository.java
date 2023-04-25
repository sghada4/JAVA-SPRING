package com.ghada.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ghada.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();

	List<Song> findByArtist(String artist);

	List<Song> findTop10ByOrderByRatingDesc();
}
