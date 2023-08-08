// package com.example.demo;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.demo.entities.Club;
// import com.example.demo.entities.League;
// import com.example.demo.services.ClubService;
// import com.example.demo.services.LeagueService;

// @SpringBootTest
// public class ClubTest {
//     @Autowired
//     ClubService ClubService;

    
//     @Test
//     public void Save(){
//         Boolean expected = true;
          
//         League league = new League(); 
//         league.setLeague_id(2);

//         Club club = new Club();
//         club.setName("Atalanta");
//         club.setLeague(leagueId);
        
//         Boolean result = ClubService.Save(Club);
        
//         assertEquals(expected, result);
//     }
    
//     // @Test
//     // public void Get(){
//     //League league = leagueService.Get(2);
         
//     //      System.out.println(league.getName());
//     // }

//     // @Test
//     // public void Delete(){
//     //     Boolean expected = true;
//     //     Integer league_id = 3;

//     //     boolean result = leagueService.Delete(league_id);

//     //     assertEquals(expected, result);
//     // }
// }
