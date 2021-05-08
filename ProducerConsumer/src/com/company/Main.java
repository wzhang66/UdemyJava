package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        // initialize the lock object to be shared with producer and consumer for them to competing for the same lock to prevent the thread interference.
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        new Thread(producer).start();
        // Note: arraylist is not thread safe, need to suspend one thread before the other thread finish its operation on the arraylist
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num: nums){
            try{
                System.out.println(color + "Adding..." + num);
                // since arraylist is not thread safe we need to use synchronized to prevent the thread interference
//                synchronized (buffer) {
//                    buffer.add(num);
//                }

                // using lock object to sychronizing parts of the execution codes
                // Recommended format using the lock object by using try ... finally ... block
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
//        synchronized (buffer) {
//            buffer.add("EOF");
//        }
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){
        while (true){
            // Check whether there are something to read, looping to check until the buffer is not empty
//            synchronized (buffer) {
//                if(buffer.isEmpty()){
//                    continue;
//                }
//                // The method will not remove the EOF string, otherwise others consumers thread will loop indefinitely
//                if(buffer.get(0).equals(EOF)){
//                    System.out.println(color + "Existing");
//                    break;
//                } else {
//                    System.out.println(color + "Removed " + buffer.remove(0));
//                }
//            }

//            Using lock object instead of synchronized block to synchronization
            bufferLock.lock();
            try{
                if(buffer.isEmpty()){
                    // release the lock to prevent infinite looping due to the holding of the lock
//                    bufferLock.unlock();
                    continue;
                }
                // The method will not remove the EOF string, otherwise others consumers thread will loop indefinitely
                if(buffer.get(0).equals(EOF)){
                    System.out.println(color + "Existing");
//                    bufferLock.unlock();
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();
            }
        }
    }
}
