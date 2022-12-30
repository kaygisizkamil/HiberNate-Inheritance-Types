package com.example.InheritanceSingleTable.domain;


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

public class Pen extends  Product{
    private String colour;
    private String whichType;

}
