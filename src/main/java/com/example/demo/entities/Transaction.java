package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_tr_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer transaction_id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    
    private String date;
    private Integer bid;
    private String info;
    private Integer contract;
    private String status;


    public Integer getTransaction_id() {
        return transaction_id;
    }
    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }
    public Club getClub() {
        return club;
    }
    public void setClub(Club club) {
        this.club = club;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getBid() {
        return bid;
    }
    public void setBid(Integer bid) {
        this.bid = bid;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Integer getContract() {
        return contract;
    }
    public void setContract(Integer contract) {
        this.contract = contract;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    } 
}
