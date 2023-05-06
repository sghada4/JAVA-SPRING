package com.team.forum.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team.forum.models.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

	List<Topic> findAll();

	// search by topicName
	List<Topic> findByTopicName(String topicName);
}
