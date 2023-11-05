package com.example.ekintyotuntilista.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HoursRepository extends CrudRepository<Hours, Double> {

	List<Hours> findById(long id);
}
