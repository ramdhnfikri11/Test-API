package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "tb_m_league")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer league_id;
    private String name;

	@OneToMany(mappedBy = "league")
    @JsonIgnore
    private List<Club> clubs;
    
    public Integer getLeague_id() {
        return league_id;
    }
    public void setLeague_id(Integer league_id) {
        this.league_id = league_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char[] findById() {
        return null;
    }
}
