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
public class JobDescription {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobid;
	private String jobname;
		
	@JsonIgnore	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
	private List<Hours> hours;
	
	public JobDescription() {
		
	}
	
	public JobDescription(String jobname) {
		super();
		this.jobname = jobname;
	}
	public Long getJobid() {
		return jobid;
	}
	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
}
