package com.squarematrix;

import java.util.Random;

public class SquareMatrixTest {


    public static void main(String[] args) {

        int [][] matrix = {
                {2,3,3,4},
                {0,2,3,4},
                {3,7,1,2},
                {4,3,3,2}
        };

        SquareMatrix newMatrix = new SquareMatrix(matrix);
        System.out.println(newMatrix);
        SquareMatrix.printAll();

        Random ran = new Random();
        int x =ran.nextInt((12 - 2) + 1) + 2;

        int y =ran.nextInt((12 - 2) + 1) + 2;
        int[][] secondMatrix= new int[x][y] ;

        for (int i= 0; i<x;i++) {
            for (int j= 0; j<y;j++) {
                secondMatrix[i][j] = ran.nextInt((8) + 1);
            }
        }

        SquareMatrix newMatrix2 = new SquareMatrix(secondMatrix);
        System.out.println(newMatrix2);
        SquareMatrix.printAll();
    }
}
