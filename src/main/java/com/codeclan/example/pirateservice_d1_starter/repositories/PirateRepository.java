package com.codeclan.example.pirateservice_d1_starter.repositories;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {
    List<Pirate> findByAge(int age);
    List<Pirate> findByFirstName(String name);
    Pirate findDistinctByFirstName(String name);
    List<Pirate> findDistinctByFirstNameOrLastName(String lastName, String firstName);
    List<Pirate> findByAgeGreaterThan(int age);
    List<Pirate> findByRaidsId(Long id);
}
