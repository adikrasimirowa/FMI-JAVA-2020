package point;

import java.util.Arrays;

public class Point {
    private double[] coords; //the x and y coordinates

    public Point(double[] coords) {
        setCoords(coords);
    }

    public Point() {
        this(new double[2]); //point with coords 0;0
    }

    public Point(Point p) {
        this(p.getCoords());
    }

    public double[] getCoords() {
        double[] copy = new double[coords.length];
        for (int i = 0; i < coords.length; i++){
            copy[i] = coords[i];
        }
        return copy;
    }

    public void setCoords(double[] coords) {
        if (coords != null && coords.length == 2){
            this.coords = new double[2];
            for (int i = 0; i < coords.length; i++){
                this.coords[i] = coords[i];
            }
        }
        else {
            this.coords = new double[]{0, 0}; // point with coords 0; 0
        }
    }

    @Override
    public String toString() {
        /*
        String result = "";
        for (int i = 0; i < coords.length; i++){
            result += String.format("double[%d] = %.2f\n", i, coords[i]);
        }
        */
        return String.format("(%.2f; %.2f)", coords[0], coords[1]);
        //форматирани до два знака
    }
}
