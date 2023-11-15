package com.example.ekintyotuntilista.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends CrudRepository<Hours, Long> {

    List<Hours> findById(long id);

    @Query("SELECT SUM(h.hourlywage * h.hours) FROM Hours h")
    Double getTotalEarnings();
}
