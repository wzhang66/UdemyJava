package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Customer customer = new Customer("Tim", 1000);
	    Customer anotherCustomer;
	    anotherCustomer = customer;
	    anotherCustomer.setBalance(222);
        System.out.println(customer.getName() + customer.getBalance());

		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(2);
		intList.add(3);
		intList.add(4);
		for (int i=0; i<intList.size(); i++){
			System.out.println(intList.get(i));
		}

		intList.add(1,33);
		for (int i=0; i<intList.size(); i++){
			System.out.println(intList.get(i));
		}
    }
}
