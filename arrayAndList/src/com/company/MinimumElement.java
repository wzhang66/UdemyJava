package com.company;

import java.util.Scanner;

public class MinimumElement {
    private static Scanner scanner = new Scanner(System.in);

    private static int readInteger(){
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private static int[] readElements(int count) {
        int[] array = new int[count];
        for(int i = 0; i<array.length; i++){
            System.out.println("Enter a number");
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;
        }
        return array;
    }
    private static int findMin(int[] array) {
        int min = array[0];
        for(int i = 0; i<array.length; i++) {
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;
    }
}
