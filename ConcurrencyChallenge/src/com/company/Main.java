package com.company;

public class Main {

    public static void main(String[] args) {
	    final BankAccount account = new BankAccount(1000.00, "12345-678");
//	    Thread t1 = new Thread(){
//            public void run() {
//                account.deposit(300.00);
//                account.withdraw(50.00);
//            }
//        };
//        Thread t2 = new Thread() {
//            public void run() {
//                account.deposit(203.75);
//                account.withdraw(100.00);
//            }
//        };
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        });

        t1.start();
        t2.start();
    }
}
