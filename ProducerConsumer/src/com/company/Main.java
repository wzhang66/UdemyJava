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
//        ArrayBlockingQueue is a thread-safe method
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        // initialize the lock object to be shared with producer and consumer for them to competing for the same lock to prevent the thread interference.
//        ReentrantLock bufferLock = new ReentrantLock();

        // Use thread pool to manage three threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);

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
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num: nums){
            try{
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e){

        }
    }
}

class MyConsumer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        while (true){
            synchronized (buffer) {
                try{
                    if(buffer.isEmpty()){
                        continue;
                    }
                    if(buffer.peek().equals(EOF)){
                        System.out.println(color + "Existing");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e){

                }
            }
        }
    }
}
