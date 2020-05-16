package main;

import java.util.Random;

import iterators7c.SelectorBackward;
import iterators7c.SelectorForward;
import iterators7c.SelectorTwoWay;
import iterators7c.Sequence;

public class SequenceTest {

    public static void main(String[] args) {
        final int SIZE = 8;

        Sequence sequence = new Sequence();

        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {

            int n = 10 + random.nextInt(91);
            sequence.add(n);
        }

        SelectorForward selector = sequence.getSelectorForward();

        while (!selector.end()) {

            System.out.println(selector.current());
            selector.next();
        }

        SelectorBackward reverseSelector = sequence.getSelectorBackward();

        while (!reverseSelector.begin()) {

            System.out.println(reverseSelector.current());
            reverseSelector.previous();
        }

        SelectorTwoWay selectorTwoWay = sequence.getSelectorTwoWay(0);

        while (!selectorTwoWay.end()) {

            System.out.println(selectorTwoWay.current());
            selectorTwoWay.next();

        }

        while(!selectorTwoWay.begin()) {

            System.out.println(selectorTwoWay.current());
            selectorTwoWay.previous();
        }

    }

}
