package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 300, 250);// Create the Scene
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scen
        Line line = new Line(0, 0, width, height);
        int count=10;
        for (int i = 0; i <10; i++ ) {

                Line line2 = new Line(i,i, 10, height);
                line2.setStroke(Color.BLUE);
                line2.setStrokeWidth(2);
                group.getChildren().add(line2);

                count--;

        }


// draw a line from the lower-left to the upper-right
        line = new Line(0, height, width, 0);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);
        group.getChildren().add(line);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
