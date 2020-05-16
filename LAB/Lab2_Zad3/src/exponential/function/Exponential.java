/*
This program calculates the value of Exponential Function e^x
Solution:
    The value of Exponential Function e^x can be expressed using Taylor Series.
    e^x = 1 + x/1! + x^2/2! + x^3/3! + ......
    e^x = 1 + (x/1) (1 + (x/2) (1 + (x/3) (........) ) )
    Let the sum needs to be calculated for n terms, we calculate sum using a loop.
* */

package exponential.function;
import java.util.Scanner;

public class Exponential {

    private double number = 0; // terms
    private int x = 0; // //raise to the power of 'e' with default value


    public Exponential() {}

    public Exponential(int x, double number) {
        if  (x >= 0) {
            setX(x);
        }

        if  (number >= 0) {
            setNumber(number);
        }
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double newNumber) {
        if (newNumber>=0) {
            number = newNumber;
        }

    }

    public void setX(int newX) {
        if (newX>=0) {
            x = newX;
        }
    }

    public double getX() {

        return x;
    }


    //Function returns approximate value of e^x
    // using sum of first n (number) terms of Taylor Series
    public static double exponential(double number, int x)
    {
        // initialize sum of series
        double sum = 1;

        for (double i = number - 1; i > 0; --i )
            sum = 1 + x * sum / i;

        return sum;
    }

    public static void main (String[] args)
    {
        Scanner input = new Scanner( System.in );
        double number;
        int x; //raise to the power of e

        System.out.println("Enter the number of terms"); //prompt
        number = input.nextDouble();
        System.out.println("Enter the power of e"); //prompt
        x = input.nextInt();
        System.out.printf("e ^ x = %.2f\n" , exponential(number,x));
    }
}

