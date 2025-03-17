package com.example.Hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Persons", schema = "hibernate_task")
public class Person {

    @EmbeddedId
    private PersonId id;

    @Column(name = "phone_number", nullable = false, length = 512)
    private String phone;

    @Column(name = "city_of_living", nullable = false, length = 512)
    private String city;
}
