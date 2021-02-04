package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Toronto", 8, 12);
        // Shallow copy of the list
//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//        printList(seatCopy);

//        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reservedSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reservedSeats);
        printList(reservedSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_OREDER);
        printList(priceSeats);

//        Collections.reverse(seatCopy);
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);
//
//
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);

    }

    public static void printList(List<Theatre.Seat> list){
        for(Theatre.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber() + "price" + seat.getPrice());
        }

        System.out.println();
        System.out.println("===================");
    }

//    public static void sortList(List<? extends Theatre.Seat> list){
//        for(int i = 0; i<list.size(); i++){
//            for (int j= i+1; j<list.size(); j++){
//                if(list.get(i).compareTo(list.get(j)) > 0){
//                    Collections.swap(list,i,j);
//                }
//            }
//        }
//    }
}
