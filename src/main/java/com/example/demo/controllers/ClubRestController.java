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

import com.example.demo.entities.Club;
import com.example.demo.services.ClubService;

import handler.Response;

@RestController
@RequestMapping("api")
public class ClubRestController {
    @Autowired
    ClubService clubService;

    @GetMapping("club")
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "data has been succesfully retrieved", clubService.Get());
    }

    @GetMapping("club/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true)Integer id ){
        return Response.generate(HttpStatus.OK, "data has been succesfully retrieved", clubService.Get(id));
    }

    @PostMapping("club")
    public ResponseEntity<Object> save(@RequestBody Club club){
        clubService.Save(club);
        return Response.generate(HttpStatus.OK, "data has been saved");
    }

    @DeleteMapping("club/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        clubService.Delete(id);
        return Response.generate(HttpStatus.OK, "data has been deleted");
    }
}
