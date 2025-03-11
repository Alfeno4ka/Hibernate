package com.example.Hibernate.repository;

import com.example.Hibernate.entity.Person;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public List<Person> getPersonsByCity (String city){
        return entityManager.createQuery("select p from Person p where p.city = ?1")
                .setParameter(1, city)
                .getResultList();
    }
}
