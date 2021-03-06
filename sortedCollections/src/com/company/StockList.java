package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if already in the stock, adjust quantity
            if(inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
//        StockItem inStock = list.getOrDefault(item, null);
//        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0) ){
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
        StockItem stockItem = list.get(item);
        if(stockItem != null && quantity>0){
            return stockItem.finalizeStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item, int quantity){
        StockItem stockItem = list.get(item);
        if(stockItem != null && quantity>0){
            return stockItem.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity){
        StockItem stockItem = list.get(item);
        if(stockItem != null && quantity>0){
            return stockItem.unreserveStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, StockItem> Items(){
        // Only the collections is unmodifiable but the item is modifiable
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item:list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " instock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost+=itemValue;
        }

        return s + "Total stock value " + totalCost;

    }
}
