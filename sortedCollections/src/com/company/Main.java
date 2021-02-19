package com.company;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.99, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.1, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.1, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 1.6, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.1, 10);
        stockList.addStock(temp);
        temp = new StockItem("chocolate", 2.1, 20);
        stockList.addStock(temp);
        temp = new StockItem("door", 4.1, 30);
        stockList.addStock(temp);

        System.out.println(stockList);

    }
}
