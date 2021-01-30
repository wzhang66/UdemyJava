package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer weiwei = new BaseballPlayer("Weiwei");
        SoccerPlayer tim = new SoccerPlayer("Tim");
        Team<FootballPlayer> mcMasterU = new Team<>("McMaster University");
        mcMasterU.addPlayer(joe);
//        mcMasterU.addPlayer(weiwei);
//        mcMasterU.addPlayer(tim);
        System.out.println(mcMasterU.numPlayers());

        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Toronto");
        baseballPlayerTeam.addPlayer(weiwei);

        Team<SoccerPlayer> soccerTeam = new Team<>("Soccer");
        soccerTeam.addPlayer(tim);

    }
}
