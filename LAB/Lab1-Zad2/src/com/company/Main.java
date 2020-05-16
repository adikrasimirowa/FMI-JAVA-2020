/*  This program checks if a five-digit  number is a palindrome*/

package com.company;
import java.util.Scanner;  // program uses class Scanner

public class Main {

    public static void main(String[] args) {
        // create Scanner to obtain input from command window
        Scanner input = new Scanner( System.in );

        int number;
        System.out.println("Enter number:"); //promt
        number=input.nextInt();

        int originalNumber = number;
        int count = 0;
        int numberCopy = number;

        // counts the digits of the number
        while(numberCopy !=0) {
           count++;
            numberCopy /= 10;
        }

        if(count==5) {
            int digit5 = originalNumber%10;
            int digit4 = (originalNumber/10)%10;
            int digit2 = (originalNumber/1000)%10;
            int digit1 = originalNumber/10000;

            // determines whether the first and last digits are identical and the second
            //and fourth digits are identica
            if(digit5 == digit1 && digit4 == digit2) {
                String resultString = originalNumber + " is a palindrome" ;
                System.out.println(resultString);
            } else {
                String resultString = originalNumber + " is not a palindrome" ;
                System.out.println(resultString);
            }
        } else {
            System.out.print("The number is not five digits");
        }
    }
}
