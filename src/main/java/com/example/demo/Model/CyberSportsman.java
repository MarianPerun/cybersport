package com.example.demo.Model;

import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CyberSportsman {

    public CyberSportsman(String nickname, String team, int salary, double winrate){
        this.nickname = nickname;
        this.team=team;
        this.salary = salary;
        this.winrate = winrate;
    }

    public CyberSportsman(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cybersportsmanid;
    public Integer getCybersportsmanid() {
        return cybersportsmanid;
    }
    public void setCybersportsmanid(Integer id) {
        this.cybersportsmanid = id;
    }

    private String nickname;
    private int salary;
    private double winrate;
    private String team;
    private int pole;

    //

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // Salary

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    // Winrate
    public double getWinrate() { return winrate; }
    public void setWinrate(double winrate){ this.winrate = winrate; }

    // Team

    public  String getTeam() {return team;}
    public void setTeam(String team){this.team = team;}

}
