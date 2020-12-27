package com.company;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if(tonerLevel > -1 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if(tonerAmount > 0 && tonerAmount <= 100) {
            if(this.tonerLevel + tonerAmount <= 100) {
                this.tonerLevel += tonerAmount;
                return this.tonerLevel;
            }
            return -1;
        }
        return -1;
    }

    public int printPages(int pages) {

        int pagesPrint = this.duplex ? (pages/2 + pages%2) : pages;
        this.pagesPrinted += pagesPrint;
        return pagesPrint;

    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
