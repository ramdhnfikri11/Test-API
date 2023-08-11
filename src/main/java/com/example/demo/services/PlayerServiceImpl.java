package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Player;
import com.example.demo.repositories.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    
    @Override
    public List<Player> Get() {
        return playerRepository.findAll();
    }

    @Override
    public Player Get(Integer id) {
        return playerRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Player model) {
        playerRepository.save(model);
        return playerRepository.findById(model.getPlayer_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        playerRepository.deleteById(id);
        return !playerRepository.findById(id).isPresent();
    }
    
}
