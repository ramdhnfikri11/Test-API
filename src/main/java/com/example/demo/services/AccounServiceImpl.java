package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entities.Person;
import com.example.demo.entities.User;

@Service
public class AccounServiceImpl implements AccountService{
    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean register(RegisterRequest registerRequest) {
        //insert person
        Person person = new Person();

        person.setEmail(registerRequest.getEmail());
        person.setName(registerRequest.getName());

        Boolean resultPerson = personService.Save(person);

        if(resultPerson){
            //insert user
            User user = new User();
            Integer person_id = personService.findIdByEmail(registerRequest.getEmail());
            


            user.setUser_id(person_id);
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            user.setPerson(personService.Get(person_id));

            Boolean resultUser = userService.Save(user);
            return resultUser;
        }
        return resultPerson;
    }

}
