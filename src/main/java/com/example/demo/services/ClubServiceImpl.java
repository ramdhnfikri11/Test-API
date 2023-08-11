package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Club;
import com.example.demo.repositories.ClubRepository;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubRepository clubRepository;

    
    @Override
    public List<Club> Get() {
        return clubRepository.findAll();
    }

    @Override
    public Club Get(Integer id) {
        return clubRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Club model) {
        clubRepository.save(model);
        return clubRepository.findById(model.getClub_id()).isPresent();
    }
    
    @Override
    public Boolean Delete(Integer id) {
        clubRepository.deleteById(id);
        return !clubRepository.findById(id).isPresent();
    }
}
