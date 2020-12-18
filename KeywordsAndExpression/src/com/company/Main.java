package com.company;

public class Main {

    public static void main(String[] args) {
        double kilometers = (100*1.609344);
        kilometers = 2.34d;
        System.out.println(kilometers);
        System.out.println(calculatekilo(500d));
    }

    public static double calculatekilo(double Inch) {
        double kilometerins = (Inch*1.609344);
        return kilometerins;
    }
}
