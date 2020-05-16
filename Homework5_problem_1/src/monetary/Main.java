package monetary;

public class Main {

    public static void main(String[] args) {
        Monetary monetaryCoin = new Monetary(Face.HEAD, 25);
        monetaryCoin.flip();
        System.out.println(monetaryCoin.toString());
        System.out.println("flip the coin");
        monetaryCoin.flip();
        System.out.println(monetaryCoin.toString());
    }
}
