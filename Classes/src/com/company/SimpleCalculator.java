package com.company;

public class SimpleCalculator {
    private double firstNumber;
    private double secondNumber;

    public double getFirstNumber(){
        return this.firstNumber;
    }

    public double getSecondNumber(){
        return this.secondNumber;
    }

    public void setFirstNumber(double first){
        this.firstNumber = first;
    }

    public void setSecondNumber(double second){
        this.secondNumber = second;
    }

    public double getAdditionResult(){
        return this.firstNumber + this.secondNumber;
    }

    public double getSubtractionResult(){
        return this.firstNumber - this.secondNumber;
    }

    public double getMultiplicationResult(){
        return this.firstNumber*this.secondNumber;
    }

    public double getDivisionResult(){
        return secondNumber == 0 ? 0 : this.firstNumber/this.secondNumber;
    }
}
