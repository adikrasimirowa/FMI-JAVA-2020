package point;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Line {

    private  Point sPoint; //starting point
    private  Point ePoint; //ending point

    public Line(Point sPoint, Point sPoint) {
       setePoint(ePoint);
       setsPoint(sPoint);
    }

    public  Line() {
    this(new Point(), new Point((new double[]{0,10})));
    }


    public Point getsPoint() {
        return new Point(sPoint);
    }

    public void setsPoint(Point sPoint) {
        if (sPoint != null) {
            this.sPoint = new Point(sPoint);
        } else {
            this.sPoint = new Point();
        }

    }

    public Point getePoint() {
        return ePoint;
    }

    public void setePoint(Point ePoint) {
        this.ePoint = ePoint;
    }

    @Override
    public String toString() {
        return "Line{" +
                "sPoint=" + sPoint +
                ", ePoint=" + ePoint +
                '}';
    }

    public void draw(Group pane) {
        javafx.scene.shape.Rectangle rectangle =
                new javafx.scene.shape.Rectangle(
                        uPoint.getCoords()[0], uPoint.getCoords()[1],
                        width, height
                );
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        pane.getChildren.add(rectangle);
    }
}
