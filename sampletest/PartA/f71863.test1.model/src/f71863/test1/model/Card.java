package f71863.test1.model;

public class Card {
    Faces face; //сила на карта
    Suits suit; // цвят на карта

    public Card(Faces face, Suits suit) {
        setFace(face);
        setSuit(suit);
    }

    public Faces getFace() {
        return face;
    }

    public void setFace(Faces face) {
        this.face = face;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return  face +
                " of " + suit ;
    }
}
