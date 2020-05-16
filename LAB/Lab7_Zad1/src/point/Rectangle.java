package point;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import javax.swing.*;

public class Rectangle {
    private Point uPoint; // upper left corner of thr rectangle
    private  double width;
    private  double height;


    public Rectangle(Point uPoint, double width, double height) {
        setHeight(height);
        setuPoint(uPoint);
        setWidth(width);
    }

    public Rectangle() {
       this(new Point(), 10, 10);
    }

    public Rectangle(Rectangle r) {
        this(r.uPoint,r.width,r.height);
    }

    public Point getuPoint() {
        return new Point(uPoint);
    }

    public void setuPoint(Point uPoint) {
        if (uPoint != null) {
            this.uPoint = new Point(uPoint);
        } else  {
            this.uPoint = new Point();
        }

    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width>0) {
            this.width = width;
        } else {
            this.width = 10;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0 ) {
            this.height = height;
        } else {
            this.width =10;
        }

    }

    @Override
    public String toString() {
        return String.format("Upper left point: %s, width: %2f," +
                " height: %.2f", uPoint.toString(),width,height);
    }

    public void draw(Group pane) {
        javafx.scene.shape.Rectangle rectangle =
                new javafx.scene.shape.Rectangle(
                        uPoint.getCoords()[0], uPoint.getCoords()[1],
                        width,height
                );
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        pane.getChildren.add(rectangle);
    }

}

