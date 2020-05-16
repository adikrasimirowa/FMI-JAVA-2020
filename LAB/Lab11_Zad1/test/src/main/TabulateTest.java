package main;
import com.Functions;
import com.Tabulate;

import functions.Computable;

public class TabulateTest {

    public static void main(String[] args) {
        
        Tabulate.tabulateFunction(1, 10, 0.1, new Computable() {

            @Override
            public double function(double x) {
                return 1 / x;
            }

        });

    }

}
