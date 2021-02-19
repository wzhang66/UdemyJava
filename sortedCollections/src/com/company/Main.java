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
        temp = new StockItem("door", 4.5, 3);
        stockList.addStock(temp);

        System.out.println(stockList);
        Basket weiweiBasket = new Basket("Weiwei");
        sellItem(weiweiBasket, "car", 1);
        System.out.println(weiweiBasket);
        sellItem(weiweiBasket, "car", 1);
        System.out.println(weiweiBasket);
        sellItem(weiweiBasket, "car", 1);
        System.out.println(weiweiBasket);


        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-199);
        System.out.println(stockList);


    }

    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
