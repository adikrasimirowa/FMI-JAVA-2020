package provider;

import java.util.Arrays;

public class Result {
    private  char[] chars;
    private  int data;

    public Result(char[] chars, int data) {
        this.chars = chars;
        this.data = data;
    }

    public char[] getChars() {
        return chars;
    }

    public int getData() {
        return data;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result {" +
                "chars=" + Arrays.toString(chars) +
                ", data=" + data +
                '}';
    }
}
