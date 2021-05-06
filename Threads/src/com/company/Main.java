package com.company;

import static com.company.ThreadColor.ANSI_CYAN;
import static com.company.ThreadColor.ANSI_PURPLE;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hi from the Main Threads");
        // Create an instance of a thread
        Thread anotherThread = new AnotherThread();
        //Reset the name of the thread
        anotherThread.setName("hello");
        anotherThread.start();
//        anotherThread.interrupt();


        // Create an anonymous thread class
        new Thread(){
            public void run(){
                System.out.println(ANSI_CYAN + "Hello from the anonymous class thread");
            }
        }.start();

        // Create a thread via a runnable interface
        Thread myRunThread = new Thread(new MyRunnable());
        myRunThread.start();

        // Runnable is more convenient and flexible for developer


//      The whether next line will show before the message from the thread depends on how fast the main thread run for example using a for loop
        System.out.println(ANSI_PURPLE+"Hello again from the Main Thread");

    }
}
