package com.company;

public class Main {

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        //раздаване на 5 карти
        Card[] leftHand = myDeckOfCards.dealHand();
        Card[] rightHand = myDeckOfCards.dealHand();
        System.out.printf( "%-20s%-20s\n", "Left hand:", "Right hand:");
        for (int i = 0; i < leftHand.length; i++) {
            System.out.printf( "%-20s%-20s\n", leftHand[i], rightHand[i]);
        }

        //намиране на силата на ръката
        System.out.printf( "\n%-20s\n", "Hand values:");
        int leftHandStrength [] = strengths(leftHand, myDeckOfCards);
        int rightHandStrength [] = strengths(rightHand, myDeckOfCards);

        //определяне на по-силна ръка
        for (int i = 0; i < leftHandStrength.length; i++){
            if (leftHandStrength[i] > rightHandStrength[i]){
                System.out.printf( "\n\nResult: left hand is better");
                System.exit(0);
            }
            if (leftHandStrength[i] < rightHandStrength[i]){
                System.out.printf( "\n\nResult: right hand is better");
                System.exit(0);
            }
        }

        System.out.printf("\n\nResult: both hands are equal");

    } // end main

   /*
      Royal flush. A, K, Q, J, 10, all the same suit. ...
      Straight flush. Five cards in a sequence, all in the same suit.
      Four of a kind. All four cards of the same rank.
      Full house. Three of a kind with a pair.
      Flush. Any five cards of the same suit, but not in a sequence.
      Straight. ...
      Three of a kind. ...
      Two pair. ...
      Pair.
      High card.

      Заради показания примерен изход игнорираме възможностите за Royal flush, Straight flush и High card.
      Наредбата ни по сила остава:

      Four of a kind. All four cards of the same rank.
      Full house. Three of a kind with a pair.
      Flush. Any five cards of the same suit, but not in a sequence.
      Straight. ...
      Three of a kind. ...
      Two pair. ...
      Pair.
      None
       */

    //array with strengths
    public static int[] strengths(Card[] hand, DeckOfCards myDeckOfCards){
        int[] strengths = new int[7];

        int couples = myDeckOfCards.pairs(hand);
        int triples = myDeckOfCards.three(hand);
        if(myDeckOfCards.four(hand)){
            strengths[0] = 1;
            System.out.printf("%-20s", "Four of a kind");
            return strengths;
        }
        if(myDeckOfCards.fullHouse(couples, triples)){
            strengths[1] = 1;
            System.out.printf("%-20s", "Full house");
            return strengths;
        }
        if(myDeckOfCards.flush(hand)){
            strengths[2] = 1;
            System.out.printf("%-20s", "Flush");
            return strengths;
        }
        if(myDeckOfCards.straight(hand)){
            strengths[3] = 1;
            System.out.printf("%-20s", "Straight");
            return strengths;
        }
        if(myDeckOfCards.triple(triples)){
            strengths[4] = 1;
            System.out.printf("%-20s", "Three of a kind");
            return strengths;
        }
        if(myDeckOfCards.twoPairs(couples)){
            strengths[5] = 1;
            System.out.printf("%-20s", "Two pairs");
            return strengths;
        }
        if(myDeckOfCards.pair(couples)){
            strengths[6] = 1;
            System.out.printf("%-20s", "One pair");
            return strengths;
        }

        System.out.printf("%-20s", "None");

        return strengths;
    }
}
