package com;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffleCards();

        System.out.println("\nDistinct Faces");
        System.out.println(deckOfCards.getDistinctFaces());

        System.out.println("\nDeal five");
        System.out.println(Arrays.toString(deckOfCards.dealFive()));

        DeckOfCards.sortByFaceCards();
        System.out.println("\nPrint by suits");
        deckOfCards.printBySuits();

    }
}
