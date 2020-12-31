package com.company;

public class Hamburger {
    private String name;
    private String meat;
    private String breadRollType;
    private double price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
    }
    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public void addHamburgerAddition1(String name, double price){
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price){
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price){
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price){
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public double itemizeHamburger() {
        System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll with " + this.meat + ", price is " + this.price);
        for(int i = 0; i < 4; i++) {
            String additionName;
            double additionPrice;
            switch (i) {
                case 0:
                    additionName = this.addition1Name;
                    additionPrice = this.addition1Price;
                    break;
                case 1:
                    additionName = this.addition2Name;
                    additionPrice = this.addition2Price;
                    break;
                case 2:
                    additionName = this.addition3Name;
                    additionPrice = this.addition3Price;
                    break;
                default:
                    additionName = this.addition4Name;
                    additionPrice = this.addition4Price;
                    break;
            }
            if(additionName != null) {
                System.out.println("Added " + additionName + " for an extra " + additionPrice);
            }
        }
        return this.price +  this.addition1Price + this.addition2Price + this.addition3Price + this.addition4Price;
    }

}
