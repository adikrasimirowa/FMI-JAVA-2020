package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf(" %.7f |", sumSeries(i));
        }
    }

    private static double sumSeries(int i) {
        if (i == 1) {
            return 1.0 / 3;
        }
        return sumSeries(i - 1) + i / (2.0 * i + 1);
    }
}
