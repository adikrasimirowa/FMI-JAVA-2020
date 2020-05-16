package point;

public class Point {

    private double[] coords; //the x and y coordinates
    public  Point(double[] cords) {

    }
    public Point() {
        this(new double[2]);
    }

    public Point(Point p) {
        this(p.getCoords());
    }

    public  double[] getCoords() {
        double[] copy = new double[coords.length];
        for (int i = 0; i<coords.length; i++) {
            copy[i] = coords[i];
        }
        return  copy;
    }
    public  void  setCoords(double[] coords) {
        if (coords != null && coords.length == 2) {
            this.coords = new double[2];
            for (int i = 0; i<coords.length; i++) {
                this.coords[i] = coords[i];
            }
        } else {
            this.coords = new double[]{0,0}; //point with coords 0:0
        }
    }

    @Override
    public  String toString(){
//        String result  = "";
//        for (int i = 0; i<coords.length; i++) {
//            result += String.format("double[%d]= %.2f",i,coords[i]);
//        }
        return  String.format("(%.f;%2f)", coords[0], coords[1]);
    }
}
