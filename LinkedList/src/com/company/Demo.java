package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Hong Kong");
        addInOrder(placesToVisit, "Tokyo");
        addInOrder(placesToVisit, "Toronto");
        addInOrder(placesToVisit, "New York");
        addInOrder(placesToVisit, "Toronto");
//        placesToVisit.add("Hong Kong");
//        placesToVisit.add("Tokyo");
//        placesToVisit.add("Toronto");
//        placesToVisit.add("New York");
        printList(placesToVisit);
        visit(placesToVisit);
    }

    public static void printList(LinkedList<String> list){
        Iterator<String> i= list.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=======================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()){
            // to initiate the listIterator, you need to use .next() to get to the first item
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0) {
                // the two item is identical, do not add
                System.out.println(newCity + " is already included");
                return false;
            } else if (comparison > 0){
                // New City should before the list item
                // Since the iterator has go to the next item using next()
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else {
                // New City should be after the list city
                // move on the next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
//      Check the direction of the listIterator
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    break;
                case 1:
                    // Checking the direction of the list iterator
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reach the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        // Checking the direction of the list iterator
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("Reach the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                default:
                    System.out.println("Enter 0, 1, 2, 3 to operate");
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available actions :\npress: ");
        System.out.println("0 - to quit\n" +
                            "1 - go to next city\n" +
                            "2 - go to previous city\n" +
                            "3 - print menu options");
    }
}
