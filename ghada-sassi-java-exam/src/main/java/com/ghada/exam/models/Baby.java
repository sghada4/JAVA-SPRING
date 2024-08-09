package com.ghada.exam.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "babies")
public class Baby {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(unique = true)
	@NotEmpty(message = "Name is required")
	@Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters !")
	private String babyname;

	@Max(value = 2, message = "Gender is required")
	@Min(value = 0, message = "Gender is required")
	private Integer gender;

	@NotEmpty(message = "Origin is required")
	@Size(min = 3, max = 100, message = "Origin must be between 3 and 100 characters !")
	private String origin;

	@NotEmpty(message = "Meaning is required")
	@Size(min = 3, max = 1000, message = "Meaning must be between 3 and 1000 characters !")
	private String meaning;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// many to one
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User postedBy;

	// Many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_babies", joinColumns = @JoinColumn(name = "baby_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> votedUsers;

	// constructors
	public Baby() {
	}

	public Baby(Long id,
			@NotEmpty(message = "Name is required") @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters !") String babyname,
			@Max(value = 2, message = "Gender is required") @Min(value = 0, message = "Gender is required") Integer gender,
			@NotEmpty(message = "Origin is required") @Size(min = 3, max = 100, message = "Origin must be between 3 and 100 characters !") String origin,
			@NotEmpty(message = "Meaning is required") @Size(min = 3, max = 1000, message = "Meaning must be between 3 and 1000 characters !") String meaning,
			Date createdAt, Date updatedAt, User postedBy, List<User> votedUsers) {
		this.id = id;
		this.babyname = babyname;
		this.gender = gender;
		this.origin = origin;
		this.meaning = meaning;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.postedBy = postedBy;
		this.votedUsers = votedUsers;
	}

	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBabyname() {
		return babyname;
	}

	public void setBabyname(String babyname) {
		this.babyname = babyname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
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

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public List<User> getVotedUsers() {
		return votedUsers;
	}

	public void setVotedUsers(List<User> votedUsers) {
		this.votedUsers = votedUsers;
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
