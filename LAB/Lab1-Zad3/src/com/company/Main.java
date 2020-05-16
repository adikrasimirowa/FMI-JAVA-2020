/* This program encrypts and decrypts four-digit integer entered by the user*/

package com.company;
import java.util.Scanner;  // program uses class Scanner

public class Main {

    public static void main(String[] args) {

        // create Scanner to obtain input from command window
        Scanner input = new Scanner( System.in );

        int data; //variable for
        int count = 0; //counter variable
        int number; //variable for the choice of the user of what he want to do with the input data
        //in the next variables we will save each digit of the number
        int digit4;
        int digit3;
        int digit2;
        int digit1;

        System.out.println("Enter your number: ");//prompt
        data = input.nextInt();

        int copyData = data; // here we copy the data from the input

        System.out.println("Press 1: For Encryption\nPress 2: For Decryption");//prompt
        number = input.nextInt();

        while (data != 0) {

            data /= 10;
            count++;
            if (data == 0 && count ==3) {
                count++;
            }
        }

        if (count==4) {
            if (number == 1 ) {
                //Encryption
                digit4 = ((copyData%10) + 7) % 10;
                digit3 = (((copyData/10)%10) + 7) % 10;
                digit2 = (((copyData/100)%10) + 7) % 10;
                digit1 = ((copyData/1000) + 7) % 10;

                System.out.print("Encrypted data:" + digit3 + digit4 + digit1 + digit2);
            } else if (number == 2) {
                //Decryption
                digit4 = ((copyData%10 + 10) % 10) - 7;
                digit3 = (((copyData/10)%10 +10) % 10) - 7;
                digit2 = (((copyData/100)%10) % 10 + 10 ) - 7;
                digit1 = ((copyData/1000) %10 + 10) - 7;

                System.out.print("Decrypted data:" + digit3 + digit4 + digit1 + digit2);
            } else {
                System.out.print("Wrong data: number is not 4 digit or wrong input");
            }
        } else {
            System.out.print("Wrong data: number is not 4 digit or wrong input");
        }
    }
}
