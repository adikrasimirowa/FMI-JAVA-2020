package com.routecipher;

import java.util.Arrays;

import static java.lang.StrictMath.abs;

public class RouteCipher {
    private static int key;

    static char [] c = new char[35];
    static int count = 0;
    static int countTwo = 0;


    public RouteCipher(int key) {
        setKey(key);
    }

    public static int getKey() {
        return key;
    }

    public void setKey(int key) {
        RouteCipher.key = key;
    }

    public static String encrypt(String plainText) {
        char [] cipherTextChars  = plainText.toCharArray(); // to char array
        int cols= abs(getKey());
        int cipherLength =  cipherTextChars.length;
        String text; // to string
        int rows = (int)Math.ceil((double) cipherLength/cols);
        int addX = (cols*rows)-cipherLength;
        char [] newArr= new char[rows*cols];
        char [][] array = new char[ rows ][ cols ];
        int currChar = 0;

        cipherTextChars = Arrays.copyOf(cipherTextChars, cipherLength+addX);

        for (int i = 0; i <addX;i++) {
            cipherTextChars[cipherLength] = 'x';
            cipherLength++;
        }



        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++){

                array[i][j] = cipherTextChars[currChar];
                currChar++;

            }
        }

        firstEncFunction(array,0,0,cols-1,rows-1,newArr,getKey());
        text = new String(newArr);
        return text;
    }

   static public String decrypt(String ciphertext) {
        char [] cipherTextChars  = ciphertext.toCharArray(); // to char array
        int cols= abs(getKey());
        int cipherLength =  cipherTextChars.length;

        String text; // to string
        int rows = (int)Math.ceil((double) cipherLength/cols);
        char [][] newArr= new char[rows][cols];

       firstDecFunction(newArr,cipherTextChars,0,0,cols-1, rows-1, getKey());
       text = new String(Arrays.deepToString(newArr));
       return text;
    }

    // helper functions for encryption

    // function to print the top-right peel of the matrix and
    // recursively call the print bottom-right on the submatrix.
    static void secondEncFunction(char[][] a, int x1, int y1, int x2, int y2, char[] newArr, int key) {
        int i = 0, j = 0;
        if (key < 0 ) {

            // print values in the column.
            for(j = y1+1; j <= y2; j++){
                newArr[count] = a[j][x1-1];
                count++;
            }

            // print values in the row.
            for(i = x1-1; i<x2; i++) {
                newArr[count] = a[y2+1][i];
                count++;
            }
        } else {
            // print the values in the col in reverse order.
            for(j = y2 ; j > y1; j--) {
                newArr[count] = a[j][x2];
                count++;
            }

            // print the values in the row in reverse order.
            for(i = x2; i>=x1; i--) {
                newArr[count] = a[y1][i];
                count++;
            }

        }

        // see if more layers need to be printed.
        if(x2-x1 > 0) {
            // if yes recursively call the function to
            // print the bottom right of the sub matrix.
            firstEncFunction(a, x1, y1 + 1, x2-1, y2,newArr,getKey());
        }
    }

    // function to print the bottom-left peel of the matrix and
    // recursively call the print top-right on the submatrix.
    static void firstEncFunction(char[][] a, int x1, int y1, int x2, int y2, char[] newArr, int key) {
        int i = 0, j = 0;

        if(key<0) {
            // print the values in the col in reverse order.
            for(j = y2 ; j > y1; j--) {
                newArr[count] = a[j][x2];
                count++;
            }

            // print the values in the row in reverse order.
            for(i = x2; i>=x1; i--) {
                newArr[count] = a[y1][i];
                count++;
            }
        } else {
            // print the values in the col  .
            for(j = y1 ; j <= y2; j++) {
                newArr[count] = a[j][x1];
                count++;
            }

            // print the values in the row .
            for(i = x1; i<x2; i++) {
                newArr[count] = a[y2][i];
                count++;
            }

        }

        // see if more layers need to be printed.
        if(x2-x1 > 0) {
            // if yes recursively call the function to
            // print the top right of the sub matrix.
            secondEncFunction(a, x1+1, y1, x2, y2-1,newArr,getKey());
        }
    }

// helper functions for decryption
    static  void firstDecFunction(char[][] newArr, char[] cipherTextChars, int x1, int y1, int x2, int y2, int key){
        int i = 0, j = 0;


        if(key<0) {
            // print the values in the col in reverse order.
            for(j = y2 ; j > y1; j--) {
                newArr[j][x2]= cipherTextChars[countTwo];
                countTwo++;
            }

            // print the values in the row in reverse order.
            for(i = x2; i>=x1; i--) {
                newArr[y1][i]= cipherTextChars[countTwo];
                countTwo++;
            }
        } else {
            // print the values in the col  .
            for(j = y1 ; j <= y2; j++) {
                newArr[j][x1]= cipherTextChars[countTwo];
                System.out.println(cipherTextChars[countTwo]);
                countTwo++;
            }

        }
        if(x2-x1 > 0) {
            secondDecFunction( newArr, cipherTextChars,  x1, y1 + 1, x2-1, y2,getKey());
        }
    }

    static  void secondDecFunction(char[][] newArr, char[] cipherTextChars, int x1, int y1, int x2, int y2, int key) {
        int i = 0, j = 0;

        if (key < 0) {

            for (j = y1 + 1; j < y2; j++) {
                newArr[j][x2-1] = cipherTextChars[countTwo];
                countTwo++;
            }

            for (i = x1 ; i < x2; i++) {
                newArr[y1 + 1][i] = cipherTextChars[countTwo];
                countTwo++;
            }
        } else {

            for (j = y2; j > y1; j--) {
                newArr[j][x2] = cipherTextChars[countTwo];
                countTwo++;
            }

            for(i = x2; i>=x1; i--) {
                newArr[y1][i]=cipherTextChars[countTwo];
                countTwo++;
            }
        }

        if(x2-x1 > 0) {
            secondDecFunction( newArr, cipherTextChars,  x1, y1 + 1, x2-1, y2,getKey());
        }
    }


    @Override
    public String toString() {
        return "RouteCipher{" +
                "key=" + key +
                '}';
    }
}
