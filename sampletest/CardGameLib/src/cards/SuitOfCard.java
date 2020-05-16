package cards;

public enum  SuitOfCard {

    CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"),
    SPADES("Spades");

    // Добавете към SuitOfCard данна suit, конструктор за инициализация
    // на suit и get метод за данната suit

    private String suit;

    SuitOfCard(String suit){
        if (suit != null) {
            this.suit = suit;
        }
    }

    public  String getFace() {
        return suit;
    }
}
