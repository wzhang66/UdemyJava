package com.company;

public class HealthyBurger extends Hamburger{
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown");
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double totalPrice = super.itemizeHamburger();
        for(int j = 0; j < 2; j++){
            String additionHealthyName;
            double additionHealthyPrice;
            switch (j) {
                case 0:
                    additionHealthyName = this.healthyExtra1Name;
                    additionHealthyPrice = this.healthyExtra1Price;
                    break;
                default:
                    additionHealthyName = this.healthyExtra2Name;
                    additionHealthyPrice = this.healthyExtra2Price;
                    break;
            }
            if(additionHealthyName != null){
                System.out.println("Added " + additionHealthyName + " for an extra " + additionHealthyPrice);
                totalPrice += additionHealthyPrice;
            }
        }
        return totalPrice;
    }
}
