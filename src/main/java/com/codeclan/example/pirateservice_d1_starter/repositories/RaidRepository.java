package com.codeclan.example.pirateservice_d1_starter.repositories;

import com.codeclan.example.pirateservice_d1_starter.models.Raid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaidRepository extends JpaRepository<Raid, Long> {
    List<Raid> findByLocation(String location);
    List<Raid> findByPiratesShipId(Long id);
}
