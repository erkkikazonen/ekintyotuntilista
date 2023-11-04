package com.example.ekintyotuntilista.domain;

import java.util.Date;

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
	private Date date;
	private Double hours;
	private Double hourlywage;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public Hours() {
		
	}
	
	public Hours(Date date, Double hours, Double hourlywage) {
		super();
		this.date = date;
		this.hours = hours;
		this.hourlywage = hourlywage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
