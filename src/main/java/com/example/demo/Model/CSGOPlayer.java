package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="csgo")
@PrimaryKeyJoinColumn(name="cybersportsmanid")
public class CSGOPlayer extends CyberSportsman {
    private String rank;
    public CSGOPlayer(String nickname, String team, int salary, double winrate,
                       String rank) {
        super(nickname, team, salary, winrate);
        this.rank = rank;

    }
    public  CSGOPlayer(){
        super();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    // . . .
}
