package sample;

public class GCD {

    public  static  int gcd(int a, int b) {
            return b == 0 ? a :gcd(b, a%b);
    }
}
