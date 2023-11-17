package com.example.ekintyotuntilista;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.ekintyotuntilista.domain.Hours;
import com.example.ekintyotuntilista.domain.HoursRepository;
import com.example.ekintyotuntilista.domain.JobDescription;
import com.example.ekintyotuntilista.domain.JobRepository;

@DataJpaTest
public class HoursRepositoryTest {

    @Autowired
    private HoursRepository hoursRepository;

    @Autowired
    private JobRepository jobRepository;

    @Test
    public void testFindAllByJobJobname() {
        // Tallenna JobDescription käyttäen jobRepositoryä
        JobDescription job = new JobDescription("Programming");
        jobRepository.save(job);

        // Luo Hours-oliot käyttäen tallennettua JobDescription-oliota
        Hours hours1 = new Hours(job, 16, 45);
        Hours hours2 = new Hours(job, 16, 45);
        hoursRepository.save(hours1);
        hoursRepository.save(hours2);

        // Hae Hours-oliot käyttäen findAllByJobJobname-metodia
        List<Hours> foundHours = hoursRepository.findAllByJobJobname("Programming");

        // Tarkista, että löydettyjen tuntien määrä on oikea
        assertEquals(2, foundHours.size());
    }
}
