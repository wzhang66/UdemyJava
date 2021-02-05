package com.company;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level lang");
        languages.put("Python", "an interpreted, OPP lang");
        languages.put("Algol", "an algorithmic language");
        languages.put("C++","lang for university");

        System.out.println(languages.get("Java"));

        System.out.println(" ================ ");

        for (String key:languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }
        System.out.println(" ================ ");
        languages.remove("Algol");

        languages.replace("Python", "Lang hot for machine learning");

        for (String key:languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }

    }
}
