package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.League;
import com.example.demo.services.LeagueService;

import handler.Response;

@RestController
@RequestMapping("api")
public class LeagueRestController {
    @Autowired
    LeagueService leagueService; 

    @GetMapping("League")
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "data has been succesfully retrieved", leagueService.Get());
    }  

    @GetMapping("League/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true)Integer id){
        return Response.generate(HttpStatus.OK, "data has been succesfully retrieved", leagueService.Get(id));
    }

    @PostMapping("League")
    public ResponseEntity<Object> save(@RequestBody League league){
        leagueService.Save(league);
        return Response.generate(HttpStatus.OK, "data has been saved");
    }

    @DeleteMapping("League/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        leagueService.Delete(id);
        return Response.generate(HttpStatus.OK, "data has been deleted");
    }
}
