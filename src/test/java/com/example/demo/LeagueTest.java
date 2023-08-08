package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.League;
import com.example.demo.services.LeagueService;

@SpringBootTest
public class LeagueTest {
    @Autowired
    LeagueService leagueService;
    
    
    @Test
    public void Save(){
        Boolean expected = true;
        
        League league = new League();
        league.setName("League Bri");
        
        Boolean result = leagueService.Save(league);
        
        assertEquals(expected, result);
    }
    
    // @Test
    // public void Get(){
    //League league = leagueService.Get(2);
         
    //      System.out.println(league.getName());
    // }

    @Test
    public void Delete(){
        Boolean expected = true;
        Integer league_id = 3;

        boolean result = leagueService.Delete(league_id);

        assertEquals(expected, result);
    }
}
