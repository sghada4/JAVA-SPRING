package com.team.forum.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.forum.models.Topic;
import com.team.forum.repositories.TopicRepository;

@Service
public class TopicService {

	// adding the topic repository as a dependency using @Autowired
	@Autowired
	private TopicRepository topicRepository;

	// READ ALL
	public List<Topic> allTopics() {
		return topicRepository.findAll();
	}

	// CREATE
	public Topic createTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	// retrieves a topic
	public Topic findTopic(Long id) {
		Optional<Topic> optionalTopic = topicRepository.findById(id);

		return optionalTopic.isPresent() ? optionalTopic.get() : null;

	}

	// Update a Topic
	public Topic updateTopic(Long id, Topic topic) {
		topic.setId(id);
		return topicRepository.save(topic);
	}

	// DELETE a Topic
	public void deleteTopic(Long id) {
		topicRepository.deleteById(id);
	}

	// Search by topicName
	public List<Topic> searchByTopicName(String topicName) {
		return topicRepository.findByTopicName(topicName);
	}
}
