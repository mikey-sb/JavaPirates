package com.codeclan.example.pirateservice_d1_starter.controllers;

import com.codeclan.example.pirateservice_d1_starter.models.Raid;
import com.codeclan.example.pirateservice_d1_starter.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RaidController {

    @Autowired
    RaidRepository raidRepository;

//    @GetMapping(value="/raids")
//    public ResponseEntity<List<Raid>> getAllRaids(){
//        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value="/raids")
    public ResponseEntity<List<Raid>> findRaidsFilterByLocation(
         @RequestParam(name="location", required = false) String location
    ){
        if(location != null){
            return new ResponseEntity<>(raidRepository.findByLocation(location), HttpStatus.OK);
        }
        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/raids/{id}")
    public ResponseEntity<Optional<Raid>> getRaidById(@PathVariable Long id){
        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/raids")
    public ResponseEntity<Raid> createRaid(@RequestBody Raid raid){
        raidRepository.save(raid);
        return new ResponseEntity<>(raid, HttpStatus.CREATED);
    }

}