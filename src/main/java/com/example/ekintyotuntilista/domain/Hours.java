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
	private int hours;
	private int hourlywage;

	@ManyToOne
	@JoinColumn(name = "jobid")
	private JobDescription job;

	public Hours() {

	}

	public Hours(JobDescription job, int hours, int hourlywage) {
		super();
		this.job = job;
		this.hours = hours;
		this.hourlywage = hourlywage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JobDescription getJob() {
		return job;
	}

	public void setJob(JobDescription job) {
		this.job = job;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getHourlywage() {
		return hourlywage;
	}

	public void setHourlywage(int hourlywage) {
		this.hourlywage = hourlywage;
	}

	@Override
	public String toString() {
		return "Hours{" + "id=" + id + ", hours=" + hours + ", hourlywage=" + hourlywage + ", job=" + job + '}';
	}
}