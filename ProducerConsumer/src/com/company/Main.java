package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        // initialize the lock object to be shared with producer and consumer for them to competing for the same lock to prevent the thread interference.
        ReentrantLock bufferLock = new ReentrantLock();

        // Use thread pool to manage three threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);

        // Note: arraylist is not thread safe, need to suspend one thread before the other thread finish its operation on the arraylist

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        // shutdown in the orderly format

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_CYAN + "I'm being printed for the Callable class");
                return "This is the callable results";
            }
        });
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e){
            System.out.println("Thread runing the task was interrupted");
        }

        executorService.shutdown();
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
        int counter = 0;

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
            if(bufferLock.tryLock()){
                try{
                    if(buffer.isEmpty()){
                        // release the lock to prevent infinite looping due to the holding of the lock
//                    bufferLock.unlock();
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;
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
            } else {
                counter++;
            }
        }
    }
}
