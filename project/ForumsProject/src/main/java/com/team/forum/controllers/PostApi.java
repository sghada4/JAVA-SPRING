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

import com.team.forum.models.Post;
import com.team.forum.services.PostService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PostApi {

	@Autowired
	private PostService postService;

	// READ ALL
	@GetMapping("/posts")
	public List<Post> allPosts() {
		return postService.allPosts();
	}

	// CREATE
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		return postService.createPost(post);
	}

	// READ ONE
	@GetMapping("/posts/{id}")
	public Post showPost(@PathVariable("id") Long id) {

		return postService.findPost(id);
	}

	// UPDATE

	@PutMapping("/posts/{id}")
	public Post updatePost(@PathVariable("id") Long id, @RequestBody Post post) {

		return postService.updatePost(id, post);
	}

	@DeleteMapping("/posts/{id}")
	public void destroy(@PathVariable("id") Long id) {
		postService.deletePost(id);
	}
}
