package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Club;

@Repository
public interface  ClubRepository extends JpaRepository<Club, Integer>{
    
}
