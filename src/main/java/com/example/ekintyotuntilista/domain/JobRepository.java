package com.example.ekintyotuntilista.domain;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<JobDescription, Long> {

	JobDescription findByJobname(String jobname);
}
