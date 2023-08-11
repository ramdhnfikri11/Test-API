package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.services.AccountService;

import handler.Response;

@RestController
@RequestMapping("api")
public class UserRestController {
    // @Autowired
    // private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @PostMapping("user/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest){
        Boolean result = accountService.register(registerRequest);
        if(result){
            Response.generate(HttpStatus.OK, "data has been saved");
        }
        return Response.generate(HttpStatus.OK,"data has been to save");
    }
}
