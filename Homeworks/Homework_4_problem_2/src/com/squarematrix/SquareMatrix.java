package com.squarematrix;


public class SquareMatrix {
    private static int[][] dataArray;

    static int bestRow = 0;

    static int bestCol = 0;

    public SquareMatrix(int[][] dataArray) {
        setDataArray(dataArray);
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    public void setDataArray(int[][] dataArray) {
        this.dataArray = dataArray;
    }

    public static int findMaxSum() {
        // Find the maximal sum platform of size 2 x 2

        int newSum = 0;

        for (int row = 0; row < dataArray.length - 1; row++)
        {

            for (int col = 0; col < dataArray.length - 1; col++)
            {
                int sum = dataArray[row][col] + dataArray[row] [col + 1] +

                        dataArray[row + 1][col] + dataArray[row + 1] [col + 1];

                if (sum > newSum)
                {
                    newSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return newSum;
    }

    public static void printAll() {

        System.out.println("Maximum sum:");
        System.out.println(findMaxSum());
        System.out.println("Submatrices with Maximum sum:");
        System.out.println("["+bestRow+","+bestCol+"]");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] ints : dataArray) {
            for (int anInt : ints) result.append(anInt).append(" ");
            result.append("\n");
        }
        return result.toString();
    }
}
