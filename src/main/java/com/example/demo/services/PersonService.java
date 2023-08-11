package com.example.demo.services;

import com.example.demo.entities.Person;


public interface PersonService extends GenericService<Person, Integer>{
    public Integer findIdByEmail(String email);
}
