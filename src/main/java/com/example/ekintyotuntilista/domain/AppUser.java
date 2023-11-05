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
public class AppUser {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String username;
		
	@JsonIgnore	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Hours> hours;
	
	public AppUser() {
		
	}
	
	public AppUser(String username) {
		super();
		this.username = username;
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
	
}
