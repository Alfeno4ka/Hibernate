package com.example.Hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "Persons", schema = "hibernate_task")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 512)
    private String name;

    @Column(nullable = false, length = 512)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Column(name ="phone_number", nullable = false, length = 512)
    private String phone;

    @Column(name = "city_of_living", nullable = false, length = 512)
    private String city;
}
