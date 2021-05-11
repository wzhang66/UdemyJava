package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static ReentrantLock lock = new ReentrantLock(true);
    // The things that the fair lock guarantee is the first-come-first-serve ordering, and the performance may be impacted due to the fairness

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        // setting priority is only a suggestion for the operating system. but may make the thread starvation more likely to happen
        //Starvation describes a situation where a thread is unable to gain regular access to shared resources and is unable to make progress. This happens when shared resources are made unavailable for long periods by "greedy" threads.
        // Whether using fair lock or let thread starvation occur depending of the situation

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i=0; i<100; i++){
//                synchronized (lock){
//                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
//                    // execute critical section of code
//                }
                lock.lock();
                try{
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
