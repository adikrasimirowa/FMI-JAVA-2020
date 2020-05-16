package iterators7b;

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

    private class SSelectorForward implements SelectorForward {
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

    private class RSelectorBackward implements SelectorBackward {

        int i = next - 1;

        @Override
        public boolean begin()        {
            return i == -1;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void previous() {
            if (i >= 0) {
                i--;
            }
        }
    }

    private class SSelectorTwoWay implements SelectorTwoWay {

        int i;

        public SSelectorTwoWay(int i) {
            this.i = i >= 0 && i < next ? i : 0;
        }

        @Override
        public boolean begin() {
            return i == -1;
        }

        @Override
        public void previous() {
            if (i >= 0) {
                i--;
            }
        }

        @Override
        public boolean end() {
            return i == obs.length - 1;
        }

        @Override
        public void next() {
            if (i < obs.length) {
                i++;
            }
        }
        @Override
        public Object current() {
            return obs[i];
        }
    }

    public SelectorForward getSelectorForward() {
        return new SSelectorForward();
    }

    public SelectorBackward getSelectorBackward() {
        return new RSelectorBackward();
    }

    public SelectorTwoWay getSelectorTwoWay(int i) {
        return new SSelectorTwoWay(i);
    }

}