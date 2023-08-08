package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_m_player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer player_id;
    private String name;
    private String nationality;
    private String position;
    private Integer price;
    private Integer contract;
    
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "player")
    private List<Transaction>transactions;

    public Integer getPlayer_id() {
        return player_id;
    }
    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getContract() {
        return contract;
    }
    public void setContract(Integer contract) {
        this.contract = contract;
    } 
    
    public Club getClub() {
        return club;
    }
    public void setClub(Club club) {
        this.club = club;
    }

}
