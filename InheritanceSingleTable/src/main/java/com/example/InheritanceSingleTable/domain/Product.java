package com.example.InheritanceSingleTable.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//even you did not specify it is manual by spring
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {
    @Id
    private long productId;
    private String name;

    // constructor, getters, setters
}