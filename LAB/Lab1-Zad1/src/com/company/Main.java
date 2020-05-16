/* This program lets user either to enter a Fahrenheit temperature and display the Celsius equivalent
or to enter a Celsius temperature and display the Fahrenheit equivalent.*/

package com.company;
import java.util.Scanner;  // program uses class Scanner

public class Main {

    public static void main(String[] args) {
        // create Scanner to obtain input from command window
        Scanner input = new Scanner( System.in );

        double F;
        double C;
        int number = 0;

        System.out.println( "Press 1: For Fahrenheit to Celsius\nPress 2: For Celsius to Fahrenheit" ); //prompt
        number = input.nextInt();

        if (number == 1) {
            System.out.println( "Enter Fahrenheit temperature:" );
            F = input.nextDouble();
            C = 5.0 / 9.0 * ( F - 32 );
            System.out.print( "Celsius: " + C );
        } else if(number == 2) {
            System.out.println( "Enter Celsius temperature:" );
            C = input.nextDouble();
            F = 9.0 / 5.0 * C + 32;
            System.out.print( "Fahrenheit: " + F );
        } else  {
            System.out.println( "Wrong number!" );
        }
    }
}
