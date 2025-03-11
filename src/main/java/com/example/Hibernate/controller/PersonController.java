package com.example.Hibernate.controller;

import com.example.Hibernate.entity.Person;
import com.example.Hibernate.repository.PersonRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Person>> getProductsByCustomer(@RequestParam("city") String city) {
        return ResponseEntity.ok(personRepository.getPersonsByCity(city));
    }

}
