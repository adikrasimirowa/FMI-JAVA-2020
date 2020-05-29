package zad3;

import java.util.ArrayList;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(14);
        list.add(24);
        list.add(14);
        list.add(17);
        list.add(31);

        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.println(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> result = new ArrayList<>();

        for(E e: list){
            if (!result.contains(e)) result.add(e);
        }

        return result;
    }
}
