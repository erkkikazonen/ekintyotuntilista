package com.example.ekintyotuntilista.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String username;
	private String paswordHash;
	private String role;
	
	
	@JsonIgnore	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Hours> hours;
	
	public User() {
		
	}
	
	public User(String username, String paswordHash, String role) {
		super();
		this.username = username;
		this.paswordHash = paswordHash;
		this.role = role;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaswordHash() {
		return paswordHash;
	}
	public void setPaswordHash(String paswordHash) {
		this.paswordHash = paswordHash;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
