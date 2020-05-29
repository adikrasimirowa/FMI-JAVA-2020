package zad1;

import java.util.Arrays;

public class GenericStackProvider {

    public static void main(String[] args) {
        GenericStack<Integer> integerStack = new GenericStack<>();
        GenericStack<String> stringStack = new GenericStack<>();

        System.out.println("Integer stack empty: " + integerStack.isEmpty());
        System.out.println("String stack empty: " + stringStack.getSize());

        for (int i = 1; i <= 20; i++){
            integerStack.push(i);
            stringStack.push("String" + i);
        }

        System.out.println("Integer peek: " + integerStack.peek());
        System.out.println("String pop: " + stringStack.pop());
        System.out.println("String peek: " + stringStack.peek());
        System.out.println("String size: " + stringStack.getSize());
    }

    private static class GenericStack<E> {

        private E[] elements;
        private int size;
        private final static int INITIAL_SIZE = 16;

        public GenericStack(int capacity) {
            elements = (E[]) new Object[capacity];
        }

        public GenericStack() {
            this(INITIAL_SIZE);
        }

        public int getSize() {
            return size;
        }

        public E peek() {
            return elements[size - 1];
        }

        public E push(E o) {
            if (size >= elements.length){
                E[] temp = (E[]) new Object[elements.length * 2];
                System.arraycopy(elements, 0, temp, 0, elements.length);
                elements = temp;
            }

            return elements[size++] = o;
        }

        public E pop() {
            return elements[--size];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            return "stack: " + Arrays.toString(elements);
        }
    }
}
