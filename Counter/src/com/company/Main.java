package com.company;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

//        the concurrency process is unpredictable
        t1.start();
        t2.start();
    }
}


class Countdown {
    // By changing the local variable from local to a private one, it may interrupt the heap (the memory shared with all threads) and cause thread interfering
//    You resolve the interference issue by creating new objects or synchronization
    // Local variable is stored in the thread's stack
    // The object instance's value is stored in the heap
    private int i;
    public void doCountdown(){
        String color;
        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        synchronized (this){
            for (i = 10; i > 0; i--){
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }

    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;
    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }
    public void run(){
       threadCountdown.doCountdown();
    }
}