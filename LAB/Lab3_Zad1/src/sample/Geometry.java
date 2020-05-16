/*
A JavaFX application that draws a circle and also a line AB orthogonal to the x- axis starting
from a given x coordinate value. It finds the intersection points of the line AB with the
circle. In case there are no intersection points the application displays an Alert dialog window with a warning
message and quit the application.
 */


package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Geometry extends Application {

    private double xOffset;
    private Group root = new Group();
    private Alert errorDlg;
    private TextInputDialog dlg;


    private void drawCircleAndLine(double yCrossPoint) {
        Circle smallCircle1 = new Circle(xOffset, yCrossPoint,5);
        smallCircle1.setStroke(Color.BLACK);

        //draw text
        Text t = new Text(xOffset+ 10, yCrossPoint,
                String.format("[%.2f,%.2f]", xOffset, yCrossPoint));
        root.getChildren().addAll(t,smallCircle1);

    }

    private void readInput(){
        dlg.setTitle("Input data");
        dlg.setContentText("Enter x: ");
        dlg.setHeaderText(null); // null is optional, we can add header if we need to
        xOffset = Double.parseDouble((dlg.showAndWait().get()));
    }
    private  void showAlert() {
        errorDlg.setTitle("Input error");
        errorDlg.setHeaderText("No intersection");
        errorDlg.setContentText(null);
        errorDlg.showAndWait();
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene  scene = new Scene(root, 300,200); // creating new Scene
        double centerX;
        double centerY;
        double radius;
        double discriminant;
        dlg = new TextInputDialog();
        errorDlg = new Alert(Alert.AlertType.ERROR);



        radius = (Math.min( scene.getWidth(), scene.getHeight()))/3;
        centerX = scene.getWidth()/2; // finding the center of x (width) of the Scene
        centerY = scene.getHeight() /2; //finding the center of y (height) of the Scene

        // input
        readInput();
        discriminant = radius*radius
                        -(centerX -xOffset)*(centerX-xOffset);

        //creating the circle
        Circle circle = new Circle(centerX,centerY , radius );
        circle.setStroke(Color.BLUE);
        circle.setFill(null);
        root.getChildren().add(circle);

        if(discriminant>=0) {

            double height = Math.sqrt(discriminant);
            double yCrossPoint = centerY - height;
            double yCrossPointTwo = centerY + height;

            Line line = new Line(xOffset, 0, xOffset, scene.getHeight());
            line.setStroke(Color.RED);
            line.setStrokeWidth(2);
            root.getChildren().add(line);

            drawCircleAndLine(yCrossPoint); //draws intersection point

            if (discriminant>0) {
                drawCircleAndLine(yCrossPointTwo);
            }

        } else {
            showAlert();//no intersection found
            Platform.exit();
        }

        primaryStage.setTitle("Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
