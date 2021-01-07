package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Banck");
        bank.addBranch("Adelaide");
        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Weiwei", 100);
        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 200);
        bank.addCustomerTransaction("Adelaide", "Weiwei", 200);
        bank.listCustomer("Adelaide", true);

    }
}
