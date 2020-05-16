package com.company;

import java.util.Scanner;

public class StockTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        String symbol;
        double oldPrice;
        double newPrice;

        System.out.println("Enter New Stock name: "); //prompt
        name = input.next();
        System.out.println("Enter New Stock symbol: "); //prompt
        symbol = input.next();

        Stock stock = new Stock(symbol, name);

        System.out.println("Set Previous Closing Price : "); //prompt
        oldPrice = input.nextDouble();
        stock.setPreviousClosingPrice(oldPrice);

        System.out.println("Set Current  Price : "); //prompt
        newPrice = input.nextDouble();
        stock.setCurrentPrice(newPrice);


        //display Rectangle information
        System.out.println("Name: " + stock.getName());
        System.out.println("Symbol: "+  stock.getSymbol());
        System.out.printf("Previous Closing Price: %.2f \n",stock.getPreviousClosingPrice());
        System.out.printf("Current Price: %.2f \n", stock.getCurrentPrice());
        System.out.printf("Change Percent: %.2f \n", stock.changePercent());







    }
}
