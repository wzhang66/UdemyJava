package com.company;

import static com.company.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from AnotherThread " + currentThread().getName());
        try{
            Thread.sleep(3000);
            System.out.println(ANSI_BLUE + "Three seconds have passed and I am awake");
        } catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
        }

    }
}
