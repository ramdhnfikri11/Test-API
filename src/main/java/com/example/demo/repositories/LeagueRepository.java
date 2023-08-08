package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.League;

public interface LeagueRepository extends JpaRepository<League, Integer>{

}
