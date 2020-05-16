/*
reproduces a drawing from Homework 2
 */

package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene  scene = new Scene(root, 300,300); //creating a scene object
        double centerX = scene.getWidth()/2; // get the center of the scene by x coordinate
        double centerY = scene.getHeight()/2; // get the center of the scene by y coordinate
        int increments =20;

        //we set a base of one horizontal and one vertical line  *the lines in the center of the figure*
        Line verticalBaseLine;
        Line horizontalBaseLine;

        Line horizontalLine;
        Line verticalLine;

        //creating the base vertical line
        verticalBaseLine = new Line(centerX+5, centerY-5, centerX+5, centerY+increments);
        verticalBaseLine .setStroke(Color.RED);
        verticalBaseLine .setStrokeWidth(2);
        root.getChildren().add(verticalBaseLine );

        //creating the base horizontal line
        horizontalBaseLine = new Line(centerX-increments, centerY+increments, centerX+5, centerY+increments);
        horizontalBaseLine.setStroke(Color.RED);
        horizontalBaseLine.setStrokeWidth(2);
        root.getChildren().add(horizontalBaseLine);

        //to generate the other lines we use a loop, and depends of  if the number is even or odd it will create different parts of the figure
        for (int counter =1; counter<=9; counter++ ) {

            if(counter%2 == 0 ) {
                //here we create the vertical lines in the right part of the figure
                verticalLine = new Line(centerX+increments-10, centerY-increments+10 , centerX+increments-10, centerY+increments);
                verticalLine.setStroke(Color.BLUE);
                verticalLine.setStrokeWidth(2);
                root.getChildren().add(verticalLine);

                //here we create the horizontal lines in the bottom part of the figure
                horizontalLine = new Line(centerX-increments, centerY+increments, centerX+increments-10, centerY+increments);
                horizontalLine.setStroke(Color.BLUE);
                horizontalLine.setStrokeWidth(2);
                root.getChildren().add(horizontalLine);

            } else {

                //here we create the vertical lines in the left part of the figure
                verticalLine = new Line(centerX-increments, centerY-increments-10, centerX-increments, centerY+increments);
                verticalLine.setStroke(Color.RED);
                verticalLine.setStrokeWidth(2);
                root.getChildren().add(verticalLine);

                //here we create the horizontal lines in the top part of the figure
                horizontalLine = new Line(centerX-increments, centerY-increments-10, centerX+increments+10, centerY-increments-10);
                horizontalLine.setStroke(Color.RED);
                horizontalLine.setStrokeWidth(2);
                root.getChildren().add(horizontalLine);
                increments += 20;

            }


        }

        primaryStage.setTitle("Figure");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
