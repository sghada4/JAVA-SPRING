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

import com.team.forum.models.Topic;
import com.team.forum.services.TopicService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TopicApi {

	@Autowired
	private TopicService topicService;

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

	// UPDATE
	@PutMapping("/topics/{id}")
	public Topic updateTopic(@PathVariable("id") Long id, @RequestBody Topic topic) {

		return topicService.updateTopic(id, topic);
	}

	//DELETE
	@DeleteMapping("/topics/{id}")
	public void destroy(@PathVariable("id") Long id) {
		topicService.deleteTopic(id);
	}
	
	//Search By topicName
	@PostMapping("/topics/search")
	public List<Topic> searchTopic(@RequestBody Topic topic){
		return topicService.searchByTopicName(topic.getTopicName());
	}
}
