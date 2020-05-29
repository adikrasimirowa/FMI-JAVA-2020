package f71863.test1.model;

public enum Faces {

    ACE("Ace"), DEUCE("Deuce"), THREE("Three"), FOUR("Four"),FIVE("Five"),
    SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine"), TEN("Ten"),
    JACK("Jack"), QUEEN("Queen"), KING("King") ;

    private String face;

    Faces(String face) {
        if (face != null) {
            this.face = face;
        }

    }

    public  String getFace() {
        return face;
    }

    @Override
    public String toString() {
        return "Faces: " + face ;
    }
}
