package com.example.Hibernate.controller;

import com.example.Hibernate.entity.Person;
import com.example.Hibernate.repository.PersonCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonCrudRepository personCrudRepository;

    public PersonController(PersonCrudRepository personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(personCrudRepository.findAllPersonByCity(city));
    }

    @GetMapping("/persons/below-age")
    public ResponseEntity<List<Person>> getPersonsBelowAge(@RequestParam("age") Integer age) {
        return ResponseEntity.ok(personCrudRepository.findAllPersonByIdAgeLessThanOrderByIdAge(age));
    }

    @GetMapping("/persons/by-name-or-surname")
    public ResponseEntity<List<Person>> getPersonsByNameOrSurname(@RequestParam(value = "name",required = false) String name,
                                                                  @RequestParam(value = "surname",required = false) String surname) {
        return ResponseEntity.ok(personCrudRepository.findAllPersonByIdNameOrIdSurname(name, surname));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello");
    }

}
