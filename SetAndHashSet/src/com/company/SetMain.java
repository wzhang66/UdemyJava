package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();
        for(int i=1; i<= 100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("squares size: " + squares.size());
        System.out.println("cubes size: " + cubes.size());

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("union size: " + union.size());
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("intersection size: " + intersection.size());

        for(int i: intersection){
            System.out.println(i);
        }

        Set<String> words = new HashSet<>();
        String sentence = "hello word";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for(String s : words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] arrayWord = ("All is becoming good").split(" ");
        String[] arrayDivine = ("To my is best friend").split(" ");
        nature.addAll(Arrays.asList(arrayWord));
        divine.addAll(Arrays.asList(arrayDivine));

        System.out.println("nature - divine: ");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("diveine - nature: ");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);



    }

    private static void printSet(Set<String> set){
        System.out.println("\t");
        for (String s: set){
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
