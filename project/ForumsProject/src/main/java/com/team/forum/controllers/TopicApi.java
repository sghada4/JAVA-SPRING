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
import com.team.forum.models.Topic;
import com.team.forum.models.User;
import com.team.forum.services.TopicService;
import com.team.forum.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TopicApi {

	@Autowired
	private TopicService topicService;

	@Autowired
	private UserService userService;

	// READ ALL
	@GetMapping("/topics")
	public List<Topic> allTopics() {
		return topicService.allTopics();
	}

	// CREATE
	@PostMapping("/topics")
	public Topic createTopic(@RequestBody Topic topic) {
		return topicService.createTopic(topic);
	}

	// READ ONE
	@GetMapping("/topics/{id}")
	public Topic showTopic(@PathVariable("id") Long id) {

		return topicService.findTopic(id);
	}

	// READ ALL POSTS TOPIC
	@GetMapping("/topics/posts/{id}")
	public List<Post> showTopicPosts(@PathVariable("id") Long id) {

		Topic topic = topicService.findTopic(id);
		return topic.getPosts();
	}

	// UPDATE
	@PutMapping("/topics/{id}")
	public Topic updateTopic(@PathVariable("id") Long id, @RequestBody Topic topic) {

		return topicService.updateTopic(id, topic);
	}

	// DELETE
	@DeleteMapping("/topics/{id}")
	public void destroy(@PathVariable("id") Long id) {
		topicService.deleteTopic(id);
	}

	// Search By topicName
	@PostMapping("/topics/search")
	public List<Topic> searchTopic(@RequestBody Topic topic) {
		return topicService.searchByTopicName(topic.getTopicName());
	}

	// Join topic
	@GetMapping("/topics/joinTopic/{topicId}/{userId}")
	public List<User> addToList(@PathVariable("topicId") Long topicId, @PathVariable("userId") Long userId) {

		// find user from the DB using id
		User loggedUser = userService.findUserById(userId);

		// grab the selected baby from the DB
		Topic thisTopic = topicService.findTopic(topicId);
		if(thisTopic.getJoinedUsers().contains(loggedUser)) {
			return thisTopic.getJoinedUsers();
		}

		// make many to many connection
		thisTopic.getJoinedUsers().add(loggedUser);

		// don't forget to save to DB
		Topic updatedTopic = topicService.updateTopic(topicId, thisTopic);

		return updatedTopic.getJoinedUsers();
	}

	// Leave topic
	@GetMapping("/topics/leaveTopic/{topicId}/{userId}")
	public List<User> removeFromList(@PathVariable("topicId") Long topicId, @PathVariable("userId") Long userId) {

		// find user from the DB using id
		User loggedUser = userService.findUserById(userId);

		// grab the selected baby from the DB
		Topic thisTopic = topicService.findTopic(topicId);
		if(!thisTopic.getJoinedUsers().contains(loggedUser)) {
			return thisTopic.getJoinedUsers();
		}

		// make many to many connection
		thisTopic.getJoinedUsers().remove(loggedUser);

		// don't forget to save to DB
		Topic updatedTopic = topicService.updateTopic(topicId, thisTopic);

		return updatedTopic.getJoinedUsers();

	}
	
	// get list of joinedUsers
		@GetMapping("/topics/joinTopic/{topicId}")
		public List<User> getJoinedUsers(@PathVariable("topicId") Long topicId) {

			// grab the selected topic from the DB
			Topic thisTopic = topicService.findTopic(topicId);

			return thisTopic.getJoinedUsers();
		}
}
