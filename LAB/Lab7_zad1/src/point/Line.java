package point;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Line {
    private Point sPoint; //starting point
    private Point ePoint; //ending point

    public Line(Point sPoint, Point ePoint) {
        setePoint(ePoint);
        setsPoint(sPoint);
    }

    public Line() {
        this(new Point(), new Point(new double[]{10, 10}));
    }

    public Line(Line l) {
        this(l.sPoint, l.ePoint);
    }

    public Point getsPoint() {
        return new Point(sPoint);
    }

    public void setsPoint(Point sPoint) {
        this.sPoint = new Point(sPoint);
    }

    public Point getePoint() {
        return new Point(ePoint);
    }

    public void setePoint(Point ePoint) {
        this.ePoint = new Point(ePoint);
    }

    @Override
    public String toString() {
        return String.format("Starting point: %s, Ending point: %s",
                sPoint.toString(), ePoint.toString());
    }

    public void draw(Group pane){
        javafx.scene.shape.Line line =
                new javafx.scene.shape.Line(
                        sPoint.getCoords()[0], sPoint.getCoords()[1],
                        ePoint.getCoords()[0], ePoint.getCoords()[1]
                );

        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        pane.getChildren().add(line);
    }
}
