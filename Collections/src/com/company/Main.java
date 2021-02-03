package com.company;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Toronto", 8, 12);

        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry!");
        }

        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry!");
        }
    }
}
