package f71863.test1.model;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private Faces face[]; //сила на карта
    private Suits suit[]; // цвят на карта
    private Card[] cards; // масив от всички карти в тестето от карти
    private int currentCard; // индекс на карта, която може да се тегли
    private Card[] hand; // масив от всички карти в една „ръка“ от карти
    private final int NUMBER_OF_CARDS = 52;

    public DeckOfCards() {

        this.cards = new Card[NUMBER_OF_CARDS];
        for (int i =0; i<cards.length; i++) {
            assert false;
            this.cards[i] = new Card(face[i%13], suit[i/13]);
        }
        this.currentCard = 0;
        this.hand = new Card[7];
        shuffleCards();
    }


    public void shuffleCards() {
        Random randomValue = new Random();
        currentCard =0;
        for (int j = 0; j < cards.length; j++)
        {
            int random = j + (randomValue.nextInt(cards.length) % (cards.length -j));
            swap(j,random);
        }
    }

    public  void swap(int k, int n) {
        if( k>=0 && k < cards.length && n>=0 && n< cards.length ) {
            Card temp = cards[k];
            cards[k] = cards[n];
            cards[n] = temp;
        }

    }

    ///по условие: разбърква елементите на списъка cards ??? пише списък, но  нямаме такъв по условие тук
    //private static ArrayList<Card> cardsList; // списък от всички карти в тестето от карти

//    public void shuffleCards() {
//        Random randomValue = new Random();
//        for (int j = 0; j < cardsList.size(); j++)
//        {
//            int random = j + (randomValue.nextInt(cardsList.size()) % (cardsList.size() -j));
//            swap(j,random);
//        }
//    }
//
//    public static void swap(int k, int n) {
//        if( k>=0 && k < cardsList.size() && n>=0 && n< cardsList.size() ) {
//            Card temp = cardsList.get(k);
//            cardsList.set(k, cardsList.get(n));
//            cardsList.set(n, temp);
//        }
//
//    }

    public void dealSeven(){
        for (int i = 0; i <7; i++) {
            if (cards[i] == null) {
                hand[i] = null;
            } else {
                hand[i] = cards[i];
            }
            currentCard++;
        }
    }

    public String printHand(Printable choice) {
        return  choice.printChoice(hand);
    }
}
