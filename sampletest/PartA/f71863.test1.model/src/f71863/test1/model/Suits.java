package f71863.test1.model;

public enum  Suits {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private String suit;

    Suits(String suit){
        if (suit != null) {
            this.suit = suit;
        }
    }

    public  String getFace() {

        return suit;
    }

    @Override
    public String toString() {
        return "Suits:" + suit ;
    }
}
