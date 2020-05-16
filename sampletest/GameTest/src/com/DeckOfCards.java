package com;

import cards.Card;
import cards.FaceOfCard;
import cards.SuitOfCard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private static int size = 52;
    private static ArrayList<Card> cards; // списък от всички карти в тестето от карти
    int currentCard; // индекс на карта, която може да се тегли



// Добавете конструктор по подразбиране, където да се инициализира currentCard
// на нула, както и инициализира данната cards с всички 52 карти (четири цвята с по
// 13 различни сили всеки) необходими за игра.
    public DeckOfCards(){
        currentCard = 0;
        cards = new ArrayList<>(size);

        for (SuitOfCard suit : SuitOfCard.values()) {

            for (FaceOfCard face : FaceOfCard.values()) {

                cards.add(new Card(face, suit));

            }
        }
    }


    //който разбърква елементите на списъка cards в случаен ред и инициализира на
    //нула currentCard .

    public void shuffleCards() {
        Random randomValue = new Random();
        for (int j = 0; j < size; j++)
        {
            // връща произволна стойност от останалите позиции
            //0 + число от [0-52]
            //1 + числп от [0 -51] и тн.
            int random = j + (randomValue.nextInt(size) % (size -j));

            swap(j,random);
        }
    }

    public static void swap(int k, int n) {
        if( k>=0 && k < size && n>=0 && n< size ) {
            Card temp = cards.get(k);
            cards.set(k, cards.get(n));
            cards.set(n, temp);
        }

    }

    //    който връща масив от 5 последователни карти от списъка cards с начална
    //    стойност на индекса им, зададена от текущата стойност на индекса currentCard.
    //    При липса на достатъчно карти в cards съответните елементи на масива се
    //    попълват с null .
    public Card[] dealFive(){
        Card[] returnCards = new Card[5];
        for (int i = 0; i <5; i++) {

            if (currentCard >= size) {
                return returnCards;
            }
            returnCards[i] = cards.get(currentCard);
            currentCard++;
        }
        return returnCards;
    }


    //    сортирани в нарастващ ред на силата на картата Face чиято стойност се определя
    //    от последователния им номер на подреждане на константите в изброимия тип
    //    FaceOfCard. .

    public static void sortByFaceCards() {

        ArrayList<FaceOfCard> faces = new ArrayList<>(Arrays.asList(FaceOfCard.values()));


        for (int i = 0; i < size - 1; i++) {
            int index = i;

            for (int j = i + 1; j < size; j++) {
                if(faces.indexOf(cards.get(j).getFace()) < faces.indexOf(cards.get(index).getFace())) {
                    index = j;
                }
            }

            if(index != i) {
               swap(i,index);
            }
        }
    }

    //    който групира картите cards по цвят (Suit) и извежда на стандартен изход името
    //    на всеки от цветовете(названието на групата), следвано от списък на картите от
    //    този цвят.
    public void printBySuits(){
        ArrayList<Card> group = new ArrayList<>(13);

        for (SuitOfCard suit : SuitOfCard.values()) {

            for (int i = 0; i < size; i++) {
                Card currentCard = cards.get(i);
                if (currentCard.getSuit() == suit) {
                    group.add(currentCard);
                }
            }

            System.out.printf("%s - %s\n", suit, group);
            group.clear();
        }
    }


    //   който връща списък на различните сили Face в cards.
    public List<FaceOfCard> getDistinctFaces(){
        List<FaceOfCard> newCards= new ArrayList<>(52);

        for (int i = 0; i < size; i++) {
            newCards.add(cards.get(i).getFace());
        }

        return newCards;
    }

}
