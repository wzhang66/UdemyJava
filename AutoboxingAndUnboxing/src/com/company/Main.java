package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        // Autoboxing: box a primative type into a object wrapper
        for(int i=0; i<10; i++){
            intArrayList.add(Integer.valueOf(i));
        }
        // Unboxing the primitive type from object wrapper.
        for(int i=0; i<10; i++){
            System.out.println(i + " --> " + intArrayList.get(i).intValue());
        }
    }
}
