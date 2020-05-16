package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mystack.MyStack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main extends Application {

    private TextField txtInput;
    private TextArea txaOutput;
    private MyStack stack;

    /**
     * Input: txtInput btnAdd btnUndo btnClear
     * Output: txaOutput
     *
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        AnchorPane root = new AnchorPane();
        GridPane gridPane = new GridPane();
        root.getChildren().add(gridPane);

        AnchorPane.setRightAnchor(gridPane, 8.0);
        AnchorPane.setLeftAnchor(gridPane, 8.0);
        AnchorPane.setTopAnchor(gridPane, 8.0);
        AnchorPane.setBottomAnchor(gridPane, 8.0);

        Label lblInput = new Label("Input:");
        Label lblOutput = new Label("Output:");
        txtInput = new TextField("");
        txtInput.setPrefColumnCount(35);
        txaOutput = new TextArea("");
        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(event -> onAdd());
        Button btnUndo = new Button("Undo");
        btnUndo.setOnAction(event -> onUndo());
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(event -> onClear());

        gridPane.add(lblInput, 0, 0);
        gridPane.add(lblOutput, 0, 1);
        gridPane.add(txtInput, 1, 0);
        gridPane.add(btnAdd, 2, 0);
        gridPane.add(btnUndo, 3, 0);
        gridPane.add(btnClear, 4, 0);
        gridPane.add(txaOutput, 1, 1, 4, 1);

        gridPane.setVgap(8.0);
        gridPane.setHgap(8.0);

        stack = new MyStack();

        primaryStage.setTitle("MyStack Test");
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }

    private void onAdd() {
        String input = txtInput.getText();
        pushElementToStack(input);
        txaOutput.appendText(String.format("%s\n", stack.toString()));
        txtInput.setText("");
    }

    private void pushElementToStack(String input) {
        if (input.matches("[+-]?\\d+")) {
            Integer number = Integer.parseInt(input);
            stack.push(number);
            txaOutput.appendText("Integer found!\n");
        } else if (input.matches("[+-]?\\d+[.]\\d*")) {
            Double number = Double.parseDouble(input);
            stack.push(number);
            txaOutput.appendText("Double found!\n");
        } else if (input.matches("\\d{2}-\\d{2}-\\d{4}")) {
            // dd-mm-yyyy
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(input, dateFormat);
            stack.push(localDate);
            txaOutput.appendText("Date found!\n");
        } else if (input.matches("\\[(.+, |.+,|.+|.+ )]")) {
            // [1,2,3,4]
            // [1, 2, 3, 4]
            txaOutput.appendText("List found!\n");
            input = input.replace("[", "");
            input = input.replace("]", "");

            int separatorIndex = input.indexOf(",");
            while (separatorIndex != -1) {
                String listItem = input.substring(0, separatorIndex).trim();
                pushElementToStack(listItem);
                input = input.substring(separatorIndex + 1);
                separatorIndex = input.indexOf(",");
            }
            pushElementToStack(input.trim());
        } else {
            stack.push(input);
            txaOutput.appendText("Text found!\n");
        }
    }

    private void onUndo() {
        if (stack.isEmpty()) {
            txaOutput.appendText("Stack is empty!\n");
            return;
        }
        stack.pop();
        txaOutput.appendText(String.format("%s\n", stack.toString()));
    }

    private void onClear() {
        txaOutput.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
