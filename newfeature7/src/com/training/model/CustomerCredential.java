package com.training.model;

import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class CustomerCredential {
	
	@Id
	@GeneratedValue
	private long ccId;
	private String username;
	private String password;
	
	public long getCcId() {
		return ccId;
	}
	public void setCcId(long ccId) {
		this.ccId = ccId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@PrePersist
	@PreUpdate
	public void encryptPassword() {
		password = Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	@PostLoad
	@PostUpdate
	@PostPersist
	public void decryptPassword() {
		password = new String (Base64.getDecoder().decode(password));
	}
	
}
