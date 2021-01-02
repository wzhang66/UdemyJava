package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(array));
        ReverseArray.reverse(array);
        System.out.println(Arrays.toString(array));
    }

}
