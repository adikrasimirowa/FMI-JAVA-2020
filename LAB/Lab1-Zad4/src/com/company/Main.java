/* This program reads a four digit integer number and outputs
    its representation in terms of the characters ‘A’, ‘C’,’G’, ‘T */

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );

        System.out.println("Enter number:");//prompt

        int number;
        number = input.nextInt();
        //we check if the number is with 4 digits
        if (number>= 1000 && number<=9999) {
            if (number % 4 == 0) {
                System.out.print('A');
            } else if (number % 4 == 1) {
                System.out.print('C');
            } else if (number % 4 == 2) {
                System.out.print('G');
            } else if (number % 4 == 3) {
                System.out.print('T');
            }
        } else {
            System.out.println("Number is not 4 digit");
        }

    }
}
