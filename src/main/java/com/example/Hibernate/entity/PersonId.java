package com.example.Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PersonId {
    @Column(nullable = false, length = 512)
    private String name;

    @Column(nullable = false, length = 512)
    private String surname;

    @Column(nullable = false)
    private int age;
}
