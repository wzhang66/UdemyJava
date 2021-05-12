package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//        System.out.println("Balance after deposit is now " + this.balance);
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//        System.out.println("Balance after withdraw is now " + this.balance);
//    }

//    public void deposit(double amount) {
//        synchronized(this) {
//            balance += amount;
//            System.out.println("Balance after deposit is now " + this.balance);
//        }
//
//    }
//
//    public synchronized void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//            System.out.println("Balance after withdraw is now " + this.balance);
//        }
//    }
    public void deposit(double amount) {
        lock.lock();
        try{
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try{
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number is " + this.accountNumber);
    }
}
