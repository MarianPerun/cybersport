package com.example.demo.Model;

import javax.persistence.*;

@Entity(name="dota2")
@PrimaryKeyJoinColumn(name="cybersportsmanid")
public class Dota2Player extends CyberSportsman {

    public Dota2Player(String nickname, String team, int salary, double winrate,
                        String rank, int mmr, String signature, String role){
        super(nickname, team, salary, winrate);
        this.mmr = mmr;
        this.rank = rank;
        this.role = role;
        this.signature = signature;
    }

    public Dota2Player(){
        super();
    }

    private String rank;
    private int mmr;
    private String role;
    private String signature;

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRank() {
        return rank;
    }

    public int getMmr() {
        return mmr;
    }

    public String getRole() {
        return role;
    }

    public String getSignature() {
        return signature;
    }

    // . . .

}
