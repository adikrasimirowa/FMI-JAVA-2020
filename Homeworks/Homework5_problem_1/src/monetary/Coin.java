package monetary;

import java.util.Random;

public class Coin {
    private Face face;
    private Random rand;

    public Coin(Face face) {
        this.face = face;
        rand = new Random();
    }

    Face getFace() {
        return face;
    }

    void setFace(Face face) {
        this.face = face;
    }

    void flip() {
        if (rand.nextBoolean()) {
            face = Face.HEAD;
        } else {
            face = Face.TAIL;
        }
    }

    boolean isHeads() {
        return face.equals(Face.HEAD);
    }

    @Override
    public String toString() {
        return String.format("Face: %s", face);
    }

    public static void main(String[] args) {
        Coin coin = new Coin(Face.HEAD);
        coin.flip();
        System.out.println(coin.getFace());
        coin.flip();
        System.out.println(coin.getFace());
        coin.flip();
        System.out.println(coin.getFace());
        coin.flip();
        System.out.println(coin.getFace());
        System.out.println(coin.toString());
    }
}
