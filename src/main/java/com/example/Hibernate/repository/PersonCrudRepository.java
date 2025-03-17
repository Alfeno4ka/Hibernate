package com.example.Hibernate.repository;

import com.example.Hibernate.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCrudRepository extends CrudRepository<Person, Long> {
    List<Person> findAllPersonByCity (String city);

    List<Person> findAllPersonByAgeLessThanOrderByAge(int age);

    List<Person> findAllPersonByNameOrSurname(String name, String surname);
}
