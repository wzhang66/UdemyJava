package com.company;

import java.util.Scanner;

public class SortedArray {
    private static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];
        String message = "[";
        for(int i = 0; i<values.length; i++) {
            values[i] = scanner.nextInt();
            message = message + values[i];
            if(i<values.length-1){
                message += ", ";
            }
        }
        message += "]";
        System.out.println(message);
        printArray(values);
        return values;
    }

    public static void printArray(int[] array) {
        for(int i = 0; i<array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] unSortArray) {
        int[] sortArray = new int[unSortArray.length];
        for(int i=0; i<unSortArray.length;i++) {
            sortArray[i] = unSortArray[i];
        }
        boolean sort = true;
        int temp;
        while (sort){
            sort = false;
            for(int i=0; i<sortArray.length - 1; i++){
                if(sortArray[i] < sortArray[i+1]){
                    temp = sortArray[i];
                    sortArray[i] = sortArray[i+1];
                    sortArray[i+1] = temp;
                    sort = true;
                }
            }
        }

        return sortArray;
    }
}
