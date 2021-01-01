package com.company;

public class Main {

    public static void main(String[] args) {
        int[] unSortArray = SortedArray.getIntegers(5);
        SortedArray.printArray(SortedArray.sortIntegers(unSortArray));
    }

}
