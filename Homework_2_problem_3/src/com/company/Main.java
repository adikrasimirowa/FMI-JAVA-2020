/*
static method drawRandomNumber() generates a random integers from within [1;3]
with the following probabilities:
P(1) = 0.2
P(2) = 0.3
P(3) = 0.5
 */

package com.company;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class Main {
    private  static Locale locale = new Locale("bg", "BG");
    private static NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale); //Returns a percentage format for the current default locale


    public static void drawRandomNumber(int min, int max){

        Random random = new Random(); // creates new random object

        // P(1) = 0.2 where P(N) denotes the probability for the number N
        if( random.nextDouble() <= 0.2 ) {
            System.out.println( percentageFormat.format(0.2) + " = " + random.ints(min,  (max + 1)).findFirst().getAsInt());
        }

        //  P(2) = 0.3 where P(N) denotes the probability for the number N
        if (random.nextDouble() <= 0.3) {
            System.out.println( percentageFormat.format(0.3) + " = " + random.ints(min,  (max + 1)).findFirst().getAsInt());
        }

        //  P(3) = 0.5 where P(N) denotes the probability for the number N
        if (random.nextDouble() <= 0.5) {
            System.out.println(  percentageFormat.format(0.5) + " = " + random.ints(min,  (max + 1)).findFirst().getAsInt());
        }
    }

    public static void main(String[] args) {

        //Calling the method drawRandomNumber() in a loop 10,000 times and displaying the probability with which the
        //        method has returned 1,2 and 3.
        System.out.println("Prints random numbers 10,000 times:");//prompt
        for (int count = 0; count < 10000; count++) {
            drawRandomNumber(1,3);
        }

        // Calling the method drawRandomNumber() in a loop 60,000 times and displaying the probability with which the
        // method has returned 1,2 and 3.
        System.out.println("Prints random numbers 6,000 times:");//prompt
        for (int count = 0; count < 60000; count++) {
            drawRandomNumber(1,3);
        }
    }
}
