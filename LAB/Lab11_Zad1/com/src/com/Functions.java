package com;

import functions.Computable;

public class Functions {

    public Computable getSinFunction() {
        return new SinFunction();
    }

    public Computable getExpFunction() {
        return new ExpFunction();
    }

    private class SinFunction implements Computable {

        @Override
        public double function(double x) {
            return Math.sin(x);
        }

    }

    private class ExpFunction implements Computable {

        @Override
        public double function(double x) {
            return Math.exp(x);
        }
    }

}
