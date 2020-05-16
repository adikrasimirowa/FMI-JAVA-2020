package monetary;

public class Monetary  extends Coin {
    private int value;

    public Monetary(Face face, int faceValue) {
        super(face);
        this.value = faceValue;
    }

    public Monetary(int faceValue) {
        this(Face.HEAD, faceValue);
    }

    public Monetary() {
        this(Face.HEAD, 5);
    }

    public int getFaceValue() {
        return value;
    }

    public void setFaceValue(int faceValue) {
        this.value = faceValue;
    }

    @Override
    public String toString() {
        return String.format("Value %d ", value) + super.toString();
    }
}