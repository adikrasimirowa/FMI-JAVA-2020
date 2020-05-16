/*
A JavaFX application in IntelliJ that reproduces a drawing from Homework 1
 */
package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();
        double width = 400;
        double height = 350;
        Scene scene = new Scene(group, width, height);

        Line line;
        int increment = 20;
        double widthStep = width / increment;
        double heightStep = height / increment;


        //right-upper corner
        for (int count = 1; count < increment; count++) {
            line = new Line(width, count * heightStep, (count) * widthStep, 0);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }

        //left-upper corner
        for (int count = 1; count < increment; count++) {
            line = new Line(count * widthStep, 0, 0, height - (count) * heightStep);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }

        //right-bottom corner
        for (int count = 1; count < increment; count++) {
            line = new Line(count * widthStep, height, width, height - (count) * heightStep);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }

        //left-bottom corner
        for (int count = 1; count < increment; count++) {
            line = new Line(0, count * heightStep, (count) * widthStep, height);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }

        primaryStage.setTitle("Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}