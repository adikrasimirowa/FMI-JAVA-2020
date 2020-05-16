package sample;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Random;


import java.awt.*;

public class Main extends Application {

    TextArea txaArray;
    private  TextArea txaPermutations;
    private  int[] array;

    private  int[] generateRandomArray() {
        int[] result =new int[4];
        Random random = new Random();
        for (int i = 0; i< result.length; i++) {
           boolean unique = true;
           int number;
            do {
                number = 1 + random.nextInt(9);
                for (int j = 0; i< i; i++) {
                if (result[j] == number){
                    //the number is  ot unique

                    unique = false;
                }
            }
            } while (!unique);
            result[i] = number;
        }
        return result;
    }

    private void computeAndDisplay(ActionEvent event) {
        int[][] result = Permutations.permutations(array);
        StringBuilder sb = new StringBuilder();
        for (int[] permutation : result) {
            sb.append(Arrays.toString(permutation));
            sb.append("\n");
        }
        txaPermutations.setText(sb.toString());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        AnchorPane root = new AnchorPane();
        GridPane pane = new GridPane();
        root.getChildren().add(pane);
        array = generateRandomArray();

        txaArray = new TextArea();
        txaArray.setPrefColumnCount(10);
        txaArray.setPrefRowCount(1);
        txaArray.setWrapText(true);
        txaArray.setEditable(false);
        txaArray.setText(Arrays.toString(array));


        txaPermutations = new TextArea();
        txaPermutations.setPrefColumnCount(10);
        txaPermutations.setPrefRowCount(1);
        txaPermutations.setWrapText(true);
        txaPermutations.setEditable(false);


        Label lblArray = new Label ("Array:");
        Label lblPermutations = new Label("The permutations");

        Button btnCompute = new Button("Compute permutations");
        btnCompute.setOnAction(this::computeAndDisplay);

        Button btnQuit = new Button("Quit");
        btnQuit.setOnAction((event) -> Platform.exit());
        pane.add(lblArray, 0 , 0);
        pane.add(txaArray, 1, 0);
        pane.add(lblPermutations, 0 , 1);
        pane.add(txaPermutations, 1, 1);
        pane.add(btnCompute, 0 , 3);
        pane.add(btnQuit, 1 , 3);

        pane.setVgap(8);
        pane.setHgap(8);

        AnchorPane.setTopAnchor(pane, 8.0);
        AnchorPane.setBottomAnchor(pane, 8.0);
        AnchorPane.setLeftAnchor(pane, 8.0);
        AnchorPane.setRightAnchor(pane, 8.0);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300,300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
