package iterators;

import java.util.Random;

public class Sequence {


    private Object[] obs;
    private int next = 0;

    public Sequence(int size) {
        obs = new Object[size];
    }

    public void add(Object x) {
        if (next < obs.length) {
            obs[next] = x;
            next++;
        }
    }

    private class Sselector implements Selector {

        int i = 0;

        public boolean end() {
            return i == obs.length;
        }

        public Object current() {
            return obs[i];
        }

        public void next() {
            if (i < obs.length) {
                i++;
            }
        }
    }

    private class Rselector implements Selector {

        int i = next - 1;

        @Override
        public boolean end() {
            return i == -1;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }
    }

    public Selector getSelector() {
        return new Sselector();
    }

    public Selector getReverseSelector() {
        return new Rselector();
    }

    public static void main(String[] args) {

        final int SIZE = 8;
        Sequence sequence = new Sequence(SIZE);

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int n = 10 + random.nextInt(91);
             sequence.add(n);
        }


        Selector selector = sequence.getSelector();
        while (!selector.end()) {
             System.out.println(selector.current());
            selector.next();
        }

        Selector reverseSelector = sequence.getReverseSelector();
        while (!reverseSelector.end()) {
            System.out.println(reverseSelector.current());
            reverseSelector.next();
        }
    }
}