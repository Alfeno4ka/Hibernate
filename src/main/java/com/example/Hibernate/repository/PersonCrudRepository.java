package com.example.Hibernate.repository;

import com.example.Hibernate.entity.Person;
import com.example.Hibernate.entity.PersonId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCrudRepository extends CrudRepository<Person, PersonId> {
    List<Person> findAllPersonByCity (String city);

    List<Person> findAllPersonByIdAgeLessThanOrderByIdAge(int age);

    List<Person> findAllPersonByIdNameOrIdSurname(String name, String surname);
}
