package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer club_id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(mappedBy = "club")
    @JsonIgnore
    private List<Player> players;
    // @OneToMany(mappedBy = "club")
    // @JsonIgnore
    // private List<Transaction> transactions;
    
    public Integer getClub_id() {
        return club_id;
    }
    public void setClub_id(Integer club_id) {
        this.club_id = club_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public League getLeague() {
        return league;
    }
    public void setLeague(League league) {
        this.league = league;
    }
}
