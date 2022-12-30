package com.example.UsingMappedSuperclass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MyEmployee extends Person{
    private String company;
}
