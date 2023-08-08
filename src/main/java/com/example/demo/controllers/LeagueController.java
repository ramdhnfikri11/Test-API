package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.League;
import com.example.demo.services.LeagueService;

@Controller
@RequestMapping("League")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("leagues", leagueService.Get());
        return "League/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false)Integer id){
        if(id != null ){
            model.addAttribute("league", leagueService.Get(id));
        }else{
             model.addAttribute("league", new League());
        }
        return "League/form";
    }

    @PostMapping("save")
    public String submit(League league){
        Boolean result = leagueService.Save(league);
        if(result){
            return "redirect:/League";
        }else{
            return "League/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true)Integer id){
        leagueService.Delete(id);
        return "redirect:/League";
    }
}
