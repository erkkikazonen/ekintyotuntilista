package com.example.ekintyotuntilista.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Hours {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double hours;
	private Double hourlywage;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private AppUser user;
	

	public Hours() {
		
	}
	
	public Hours(AppUser user, Double hours, Double hourlywage) {
		super();
		this.user = user;
		this.hours = hours;
		this.hourlywage = hourlywage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AppUser getUser() {
		return user;
	}
	
	public void setUser(AppUser user) {
		this.user = user;
	}
	
	public Double getHours() {
		return hours;
	}
	public void setHours(Double hours) {
		this.hours = hours;
	}
	public Double getHourlywage() {
		return hourlywage;
	}
	public void setHourlywage(Double hourlywage) {
		this.hourlywage = hourlywage;
	}
	
}
