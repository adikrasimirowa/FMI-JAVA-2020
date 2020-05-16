package iterators7c;
import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private List obs;

    public Sequence() {
        obs = new ArrayList();
    }

    public void add(Object x) {
        obs.add(x);
    }

    private class SSelectorForward implements SelectorForward {

        int i = 0;
        public boolean end() {

            return i == obs.size();
        }

        public Object current() {

            return obs.get(i);
        }

        public void next() {

            if (i < obs.size()) {
                i++;
            }
        }
    }

    private class RSelectorBackward implements SelectorBackward {

        int i = obs.size() - 1;

        @Override
        public boolean begin()        {

            return i == -1;
        }

        @Override
        public Object current() {

            return obs.get(i);
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

             this.i = i >= 0 && i < obs.size() ? i : 0;
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

            return i == obs.size() - 1;
        }

        @Override
        public void next() {

            if (i < obs.size()) {
                i++;
            }
        }
        @Override
        public Object current() {

            return obs.get(i);
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