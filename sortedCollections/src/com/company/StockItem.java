package com.company;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock; // can be initialized later
    private int reserved = 0;

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0; // or here
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock - reserved;
    }

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        this.quantityStock += quantity;
    }

    public int unreserveStock(int quantity){
        if(quantity <= reserved){
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int reserveStock(int quantity){
        if(quantity <= quantityInStock()){ // Use the method not the field
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity){
        if(quantity <= reserved){
            quantityStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");

        // Check whether these are the same object in the memory
        if(obj == this){
            return true;
        }
        // Check the classtype
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering stockItem.compareTo");
        if(this == o){
            return 0;
        }
        // check null variable
        if(o != null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price " + this.price + ", Reserva" + this.quantityStock;
    }
}
