package com.company;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20,20,5);
	    Case theCase = new Case("220B" ,"Dell", "24", dimensions);
	    Monitor theMonitor = new Monitor("27inch Beast", "AOC",28, new Resolution(2540, 1440));
        Motherboard motherboard = new Motherboard("Z390", "Gigabyte", 4, 6, "v2.44");

        PC thePC = new PC(theCase, theMonitor, motherboard);

        thePC.powerUp();
    }
}
