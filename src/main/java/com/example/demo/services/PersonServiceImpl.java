package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> Get() {
        return personRepository.findAll();
    }

    @Override
    public Person Get(Integer id) {
        return personRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Person model) {
        personRepository.save(model);
        return personRepository.findById(model.getPerson_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        personRepository.deleteById(id);
        return !personRepository.findById(id).isPresent();
    }

    @Override
    public Integer findIdByEmail(String email) {
        return personRepository.findIdByEmail(email);
    }
    
}
