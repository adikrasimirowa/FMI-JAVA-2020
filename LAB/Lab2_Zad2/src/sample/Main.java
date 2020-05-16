/*
This program draws 12 concentric circles that overlap each other and horizontal and vertical diameters of the last circle
 */

package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape
import javafx.scene.shape.*;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene  scene = new Scene(root, 300,300);
        double centerX = scene.getWidth()/2;
        double centerY = scene.getHeight() /2;
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene
        int count = 0;
        int increments =20;

//        while (count<12){
//
//        }

        // draw a horizontal line
        Line line = new Line(centerX, increments , centerX, height-increments);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        root.getChildren().add(line);
        // draw a vertical line
        line = new Line(increments, centerY, width-increments, centerY);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        root.getChildren().add(line);


        Arc arc = new Arc();
        arc.setCenterX(300.0);
        arc.setCenterY(150.0);
        arc.setRadiusX(90.0);
        arc.setRadiusY(90.0);
        arc.setStartAngle(40.0);
        arc.setLength(239.0);
        arc.setType(ArcType.OPEN);
        root.getChildren().add(arc);

        primaryStage.setTitle("Circle");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
