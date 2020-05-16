package com.routecipher;

import java.util.Arrays;

public class RouteCipherTest {


    public static void main(String[] args) {
        new RouteCipher(-5);
        String cipherText = "Abort the mission, you have been spotted";
        cipherText = cipherText.replaceAll("[^a-zA-Z]","");
        System.out.println(cipherText);
        System.out.println(RouteCipher.encrypt(cipherText));

        //decryption not working properly
        String test = "TIEIXTXXEAHSIHSPNTLT";
        System.out.println(RouteCipher.decrypt(test));
    }
}
