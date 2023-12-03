package com.example.InDataCore_Test.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String street;
    private String city;
    private String state;
    private int zip;
    private double dollar;
    private String pick;
    private String date;
}
