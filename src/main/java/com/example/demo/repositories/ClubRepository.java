package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Club;

public interface  ClubRepository extends JpaRepository<Club, Integer>{
    
}
