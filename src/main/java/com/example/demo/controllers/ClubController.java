package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Club;
import com.example.demo.services.ClubService;
import com.example.demo.services.LeagueService;

@Controller
@RequestMapping("club")
public class ClubController {
    @Autowired
    ClubService clubService;

    @Autowired
    LeagueService leagueService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("clubs", clubService.Get());
        return "club/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false)Integer id){
        if(id != null ){
            model.addAttribute("leagues", leagueService.Get());
            model.addAttribute("club", clubService.Get(id));
        }else{
            model.addAttribute("leagues", leagueService.Get());
            model.addAttribute("club", new Club());
        }
        return "club/form";
    }

    @PostMapping("save")
    public String submit(Club club){
        Boolean result = clubService.Save(club);
        if(result){
            return "redirect:/club";
        }else{
            return "club/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(Club club, @PathVariable(required = true)Integer id){
        clubService.Delete(id);
        return "redirect:/club";
    }
}
