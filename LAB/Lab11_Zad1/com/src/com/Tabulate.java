package com;
import java.util.Scanner;

import functions.Computable;

public class Tabulate {

    private Computable callback;

    private static Scanner kbd = new Scanner(System.in);

    public Tabulate(Computable callback) {

        setCallback(callback);
    }

    public Computable getCallback() {
        return callback;
    }

    public void setCallback(Computable callback) {
        if (callback != null) {
            this.callback = callback;
        } else {
            Functions functions = new Functions();
            this.callback = functions.getSinFunction();
        }
    }

    public void tabulate(double a, double b, double step) {

        tabulateFunction(a, b, step, callback);
    }

    public static void tabulateFunction( double a, double b, double step, Computable function) {
        if (step < 0) {

            System.out.println("Please provide well defined step!");
            return;

        }
        if (a >= b) {

            System.out.println("Please provide well defined interval!");
            return;

        }

        System.out.printf("%10s%10s%n", "X", "F(X)");
        double size = (b - a) / step;
        for (int i = 1; i <= size; i++) {
            double x = a + i * step;
            double y = function.function(x);
            System.out.printf("%10.2f%10.2f%n", x, y);
            if (i % 20 == 0) {
                System.out.println("Please press Enter to continue...");
                kbd.nextLine();
            }
        }
    }
}