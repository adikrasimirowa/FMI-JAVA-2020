package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CeasarCipher cipher = new CeasarCipher();

        System.out.println("Encrypt\"TOY\"by default");
        System.out.println(cipher.encrypt("TOY"));
        System.out.println("Decrypt\"WRB\"by default");
        System.out.println(cipher.decrypt("WRB"));
        System.out.println();

        System.out.println("Encrypt\"ABCD\"by key -3 ...");
        cipher = new CeasarCipher(-3);
        System.out.println(cipher.encrypt("ABCD"));
        System.out.println("Decrypt\"XYZA\"by key -3 ...");
        System.out.println(cipher.decrypt("XYZA"));


    }
}
