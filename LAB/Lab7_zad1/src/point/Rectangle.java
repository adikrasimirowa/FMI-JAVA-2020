package point;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Rectangle {
    private Point uPoint; //Upper left corner of the rectangle
    private double width;
    private double height;

    public Rectangle(Point uPoint, double width, double height) {
        setHeight(height);
        setuPoint(uPoint);
        setWidth(width);
    }

    public Rectangle() {
        this(new Point(), 10, 10);
    }

    public Rectangle(Rectangle r) {
        this(r.uPoint, r.width, r.height);
    }

    public Point getuPoint() {
        return new Point(uPoint);
    }

    public void setuPoint(Point uPoint) {
        this.uPoint = new Point(uPoint);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0){
            this.width = width;
        }
        else{
            this.width = 10;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0){
            this.height = height;
        }
        else{
            this.height = 10;
        }
    }

    @Override
    public String toString() {
        return String.format("Upper left point: %s, " +
                "width: %.2f, height: %.2f\n",
                uPoint.toString(), width, height);

    }

    public void draw(Group pane){
        javafx.scene.shape.Rectangle rectangle =
                new javafx.scene.shape.Rectangle(
                        uPoint.getCoords()[0], uPoint.getCoords()[1],
                        width, height
                );

        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        pane.getChildren().add(rectangle);
    }
}
