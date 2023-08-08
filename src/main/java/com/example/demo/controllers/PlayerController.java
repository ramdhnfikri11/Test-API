package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Player;
import com.example.demo.services.ClubService;
import com.example.demo.services.PlayerService;

@Controller
@RequestMapping("player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    ClubService clubService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("players", playerService.Get());
        return "player/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false)Integer id){
        if(id != null ){
            model.addAttribute("clubs", clubService.Get());
            model.addAttribute("player", playerService.Get(id));
        }else{
            model.addAttribute("clubs", clubService.Get());
            model.addAttribute("player", new Player());
        }
        return "player/form";
    }

    @PostMapping("save")
    public String submit(Player player){
        Boolean result = playerService.Save(player);
        if(result){
            return "redirect:/player";
        }else{
            return "player/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(Player player, @PathVariable(required = true)Integer id){
        playerService.Delete(id);
        return"redirect:/player";
    }
}
