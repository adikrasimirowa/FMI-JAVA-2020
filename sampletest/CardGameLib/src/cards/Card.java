package cards;

public class Card {
    FaceOfCard face; // сила на карта
    SuitOfCard suit; // цвят на карта

    //конструктор за общо ползване
    public Card(FaceOfCard face, SuitOfCard suit) {
        setFace(face);
        setSuit(suit);
    }

    //get и set методи
    public FaceOfCard getFace() {
        return face;
    }

    public SuitOfCard getSuit() {
        return suit;
    }

    public void setFace(FaceOfCard face) {
        this.face = face;
    }

    public void setSuit(SuitOfCard suit) {
        this.suit = suit;
    }
    //предефинирайте метода toString(), онаследен от клас Object, така че да връща
    //форматиран стринг с всички данни на инстанцията в следния вид
    //<сила на карта> of <цвят на карта>, например, King of Diamonds
    @Override
    public String toString() {
        return face + " of " + suit ;
    }
}
