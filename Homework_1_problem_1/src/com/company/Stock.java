package com.company;

public class Stock {
    private String symbol; //the symbol of this stock
    private String  name; // the name of this stock
    private double previousClosingPrice; //the previous closing price of this stock
    private double currentPrice; // the current price of this stock

    //constructs a stock with a specified symbol and a name
    public Stock(String symbol, String name) {
        if (symbol != null) {
            this.symbol = symbol;
        }
        if (name != null) {
            this.name = name;
        }
    }

    //returns the symbol of this stock
    public String getSymbol() {
        return symbol;
    }

    //returns the name of this stoc
    public String getName() {
        return name;
    }

    //returns the previous closing price of this stock
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    //returns the current price of this stock
    public double getCurrentPrice() {
        return currentPrice;
    }

    //sets he previous closing price of this stock
    public void setPreviousClosingPrice(double previousClosingPrice) {
        if (previousClosingPrice >= 0) {
            this.previousClosingPrice = previousClosingPrice;
        }
    }

    //sets the current price of this stock
    public void setCurrentPrice(double currentPrice) {
        if (currentPrice >= 0){
            this.currentPrice = currentPrice;
        }
    }

    //returns the percentage of change of this stock
    public  double changePercent(){
            return ((previousClosingPrice - currentPrice)/currentPrice)*100;
    }


}
