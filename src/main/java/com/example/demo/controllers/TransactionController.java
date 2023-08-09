package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Transaction;

import com.example.demo.services.ClubService;
import com.example.demo.services.PlayerService;
import com.example.demo.services.TransactionService;

@Controller
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    ClubService clubService;

    @Autowired
    PlayerService playerService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("transactions", transactionService.Get());
        return "transaction/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false)Integer id){
        if(id != null){
            model.addAttribute("clubs", clubService.Get());
            model.addAttribute("players", playerService.Get());
            model.addAttribute("transaction", transactionService.Get(id));
        }else{
            model.addAttribute("clubs", clubService.Get());
            model.addAttribute("players", playerService.Get());
            model.addAttribute("transaction", new Transaction());
        }
        return "transaction/form";
    }

    @PostMapping("save")
    public String submit(Transaction transaction){
        Boolean result = transactionService.Save(transaction);
        if(result){
            return "redirect:/transaction";
        }else{
            return "transaction/form";
        }

    }
}
