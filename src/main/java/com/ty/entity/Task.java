package com.ty.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Task {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int taskId;
      private String description;
      @CreationTimestamp
      private LocalDateTime createdTime;
      @UpdateTimestamp
      private LocalDateTime completedTime;
      private String status;
      @ManyToOne
      @JoinColumn(name = "user_id")
      private UserInfo user;
      
      
      
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTaskId() {
		return taskId;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
      
      
}
