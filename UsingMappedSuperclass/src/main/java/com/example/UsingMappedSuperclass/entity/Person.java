package com.example.UsingMappedSuperclass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//it is not mapped to db by manuAl
//MappedSuperclass – the parent classes, can't be entities

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    private String name;

    // constructor, getters, setters
}