package com.example.Hibernate.controller;

import com.example.Hibernate.entity.Person;
import com.example.Hibernate.repository.PersonCrudRepository;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class PersonController {
    private final PersonCrudRepository personCrudRepository;

    public PersonController(PersonCrudRepository personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    @Secured("READ")
    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(personCrudRepository.findAllPersonByCity(city));
    }

    @RolesAllowed("WRITE")
    @GetMapping("/persons/below-age")
    public ResponseEntity<List<Person>> getPersonsBelowAge(@RequestParam("age") Integer age) {
        return ResponseEntity.ok(personCrudRepository.findAllPersonByIdAgeLessThanOrderByIdAge(age));
    }

    @PreAuthorize("hasAuthority('DELETE') and (#name == authentication.principal.username)")
    @GetMapping("/persons/by-name-or-surname")
    public ResponseEntity<List<Person>> getPersonsByNameOrSurname(@RequestParam(value = "name",required = false) String name,
                                                                  @RequestParam(value = "surname",required = false) String surname) {
        return ResponseEntity.ok(personCrudRepository.findAllPersonByIdNameOrIdSurname(name, surname));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloPublic() {
        return ResponseEntity.ok("Hello (public)");
    }
}
