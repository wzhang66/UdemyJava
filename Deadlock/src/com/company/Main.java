package com.company;

public class Main {
    // initializing two locks
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        // A deadlock occurs when two or more threads are blocked on locks and every thread that's blocked is holding a lock that another block thread wants
        // Key to avoid deadlock is that all the threads is competing for the locks in the same other. In the following example if you switch the lock order in thread2, there will be a deadlock

        (new Thread1()).start();
        new Thread2().start();

    }

    private static class Thread1 extends Thread {
        public void  run(){
            synchronized (Main.lock1) {
                System.out.println("Thread 1: has lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1 waiting for lock 2");
                synchronized (Main.lock2) {
                    System.out.println("Thread 1: Has lock 1 and lock 2");
                }
                System.out.println("Thread 1: Released Lock 2");
            }
            System.out.println("Thread 1 releasing lock 1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void  run(){
            synchronized (Main.lock1) {
                System.out.println("Thread 2: has lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2 waiting for lock 2");
                synchronized (Main.lock2) {
                    System.out.println("Thread 2: Has lock 1 and lock 2");
                }
                System.out.println("Thread 2: Released Lock 2");
            }
            System.out.println("Thread 2 releasing lock 1. Exiting...");
        }
    }
}

