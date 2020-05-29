package zad4567;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        //зад 4 тест
        Integer[] intArray = new Integer[]{1, 3, 5, -2};
        System.out.println("Array: " + Arrays.toString(intArray));
        System.out.println("Linear search 3 index: " +
                linearSearch(intArray,3));
        System.out.println("Linear search -7 index: " +
                linearSearch(intArray,-7));

        //зад 5 тест
        Integer[][] numbers = {{1, 7, 3},{4, 4, 6},{-1, 9, 2}};
        System.out.println("Max matrix: " + max(numbers));

        //зад 6 тест
        System.out.println("Unsorted: " + Arrays.toString(intArray));
        insertionSort(intArray);
        System.out.println("Sorted: " + Arrays.toString(intArray));

        //зад 7 тест
        ArrayList<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(7);
        list.add(1);
        list.add(347);
        list.add(32);

        System.out.println("List: " + list);
        shuffle(list);
        System.out.println("Shuffled: " + list);
        selectionSort(list);
        System.out.println("Sorted: " + list);
    }

    //зад 4
    public static <E> int linearSearch(E[] list, E key){
        for (int i = 0; i < list.length; i++){
            if (list[i].equals(key)) return i;
        }

        return -1;
    }

    //зад 5
    public static <E extends Comparable<E>> E max(E[][] list){
        E max = list[0][0];
        for (int i = 0; i < list.length; i++){
            for(int j = 0; j< list[i].length; j++){
                if(max.compareTo(list[i][j]) < 0){
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    //зад 6
    public static <E extends Comparable<E>> void insertionSort(E[] list){
        for (int i = 1; i < list.length; i++){
            E current = list[i];
            int k;
            for ( k = i - 1; k >= 0 && list[k].compareTo(current) > 0; k--){
                list[k + 1] = list[k];
            }
            list[k+1] = current;
        }
    }

    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.size() - 1; i++) {
            currentMin = list.get(i);
            currentMinIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }

    //зад 7
    public static <E> void shuffle(ArrayList<E> list){
        for (int i = 0; i < list.size() - 1; i++){
            // проверка за избягване на повторение на индекси
            int index =(int) (Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}
