package zad2;

public class GenericStackAsArrayListTest {
    public static void main(String[] args) {
        GenericStack<String> stringStack = new GenericStack<>();
        for (int i = 1; i <= 5; i++){
            stringStack.push("String" + i);
        }
        /*
        for (int i = 1; i <= 5; i++){
            System.out.println(stringStack.pop());
        }

         */
        while(!stringStack.isEmpty()){
            System.out.println(stringStack.pop());
        }
    }
    private static class GenericStack<E> extends java.util.ArrayList<E>{

        public int getSize() {
            return size();
        }

        public E peek() {
            return get(getSize() - 1);
        }

        public E push(E o) {
            add(o);
            return o;
        }

        public E pop() {
            E o = get(getSize() - 1);
            super.remove(getSize() - 1);
            return o;
        }

        public boolean isEmpty() {
            return super.isEmpty();
        }

        @Override
        public String toString() {
            return "stack: " + super.toString();
        }
    }
}
