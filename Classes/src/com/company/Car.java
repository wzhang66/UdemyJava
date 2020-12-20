package com.company;

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public void setModel(String model){
        this.model = model;
    }
    public void showModel(){
        System.out.println(this.model);
    }
}
