package com.team.forum.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.forum.models.Post;
import com.team.forum.repositories.PostRepository;

@Service
public class PostService {

	// adding the post repository as a dependency using @Autowired
	@Autowired
	private PostRepository postRepository;

	// READ ALL
	public List<Post> allPosts() {
		return postRepository.findAll();
	}

	// CREATE
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	// retrieves a post
	public Post findPost(Long id) {
		Optional<Post> optionalPost = postRepository.findById(id);

		return optionalPost.isPresent() ? optionalPost.get() : null;

	}

	// Update a Post
	public Post updatePost(Long id, Post post) {
		post.setId(id);
		return postRepository.save(post);
	}

	// DELETE a Post
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
}
