package sample;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Permutations {

    private static int factorial(int n) {
        if(n == 0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public  static  int[][] permutations(int[] arr) {
        int[][] result = new  int[factorial(arr.length)][arr.length];// memory n! * n
        computePermutations(0,arr,result);
        return  result;

    }

    private  static  void  computePermutations(int currentIndex, int[] arr, int[][] result) { //n
        int count =0;
        if(currentIndex == arr.length -1) {
            int[] perm = Arrays.copyOf(arr, arr.length);
            result[count] = perm;
            count++;
            return;
        }
            int temp;
            for (int i = currentIndex; i < arr.length; i++){
                //1,2,3,4
                //2,1,3,4
                //1,2,3,4
                temp = arr[currentIndex];
                arr[currentIndex] = arr[i];
                arr[i] = temp;
                computePermutations(currentIndex+1,arr,result);

                temp = arr[currentIndex];
                arr[currentIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }



