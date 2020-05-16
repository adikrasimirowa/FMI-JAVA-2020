package com.hammingcode;

import java.util.Scanner;

public class Main {

    // Function to calculate hamming distance
    //Hamming Distance between two integers is the number of bits which are different at same position in both numbers.
    static int hammingDistance(int n1, int n2)
    {
        int x = n1 ^ n2;
        int setBits = 0;

        while (x > 0)
        {
            setBits += x & 1; // using bitwise operator AND
            x >>= 1; // assignment operator x = x >> y , >> shift x right by y bits, with sign extension

        }
        return setBits;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int firstNumber;
        int secondNumber;

        System.out.println("Enter first number: "); //prompt
        firstNumber = input.nextInt();

        System.out.println("Enter second number: "); //prompt
        secondNumber = input.nextInt();

        byte firstBin = (byte) firstNumber;
        byte secondBin = (byte) secondNumber;

        System.out.println(firstNumber+": " + String.format("%8s",
                Integer.toBinaryString(0xFF & firstBin)).replaceAll(" ", "0"));
        System.out.println(secondNumber+": " + String.format("%8s",
                Integer.toBinaryString(0xFF & secondBin)).replaceAll(" ", "0"));

        System.out.println("Distance: " + hammingDistance(firstNumber, secondNumber));
    }

}
