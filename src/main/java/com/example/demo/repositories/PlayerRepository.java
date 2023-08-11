package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
}
