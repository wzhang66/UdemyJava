package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read(){
        while (empty){
            try{
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = true;
        // notifyAll() is commonly used before, we cannot assign a specific thread since notify() does not accept any parameters. Unless we are in a situation where there are a lot of threads performing similar task.
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        while (!empty){
            try{
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = false;
        notifyAll();
        this.message = message;
    }
}

class Writer implements Runnable {
    private Message message;
    public Writer(Message message){
        this.message = message;
    }

    public void run(){
        String messages[] ={
                "hasdfsf lgaewf asfsdf",
                "sadfsaoe dfjnn asaef",
                "asdfwekv vvbrtgts sdfa ef",
                "asdfi vlromrq vfa"
        };

        // Create a random object for waiting time
        Random random = new Random();

        for(String m : messages){
            message.write(m);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable{
    private Message message;
    public Reader(Message message){
        this.message = message;
    }
    public void run(){
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()){
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
    }

}