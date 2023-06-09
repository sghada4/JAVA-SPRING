package com.team.forum.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "topics")

public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required!")
	@Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
	private String topicName;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// one to many
	@OneToMany(mappedBy = "postedIn", fetch = FetchType.LAZY)
//	@JsonIgnore
//	@JsonIgnoreProperties({"posts"})
//	@JsonIgnoreProperties(value="postedIn", allowSetters = true)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Post> posts;

	// many to one
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
//	@JsonIgnore
//	@JsonIgnoreProperties({"topicPostedBy"})
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
//	@JsonProperty(access = Access.READ_ONLY)
	private User topicPostedBy;

	// many to one
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id")
//	@JsonIgnore
//	@JsonIgnoreProperties({"theme"})
//	@JsonIgnoreProperties(value="theme_id", allowSetters = true)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Theme theme;

	// Many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_topics", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//	@JsonIgnore
//	@JsonIgnoreProperties({"joinedUsers"})
//	@JsonIgnoreProperties(value="topic_id", allowSetters = true)
	//@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
	private List<User> joinedUsers;

	// CONSTRUCTOR
	public Topic() {
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User getTopicPostedBy() {
		return topicPostedBy;
	}

	public void setTopicPostedBy(User topicPostedBy) {
		this.topicPostedBy = topicPostedBy;
	}

	public List<User> getJoinedUsers() {
		return joinedUsers;
	}

	public void setJoinedUsers(List<User> joinedUsers) {
		this.joinedUsers = joinedUsers;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
