package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.League;
import com.example.demo.repositories.LeagueRepository;


@Service
public class LeagueServiceImpl implements LeagueService{
    @Autowired
    private LeagueRepository leagueRepository;

    @Override
    public List<League> Get() {
        return leagueRepository.findAll();
    }

    @Override
    public League Get(Integer id) {
        return leagueRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(League model) {
        leagueRepository.save(model);
        return leagueRepository.findById(model.getLeague_id()).isPresent();
    }
    
    @Override
    public Boolean Delete(Integer id) {
        leagueRepository.deleteById(id);
        return !leagueRepository.findById(id).isPresent();
    }



}
