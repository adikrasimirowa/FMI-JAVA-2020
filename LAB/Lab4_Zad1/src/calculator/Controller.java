package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCalculation;

    Double temp = 0.0, sum = 0.0;
    boolean isOperatorPressed;
    String operatorPressed = ""; // here we store the operator that is pressed

    @FXML
    void addNumberOnAction(ActionEvent event) {
        //checks if the event is instance of a button, then a new button object is created
        //the new btn objects stores the value (source) of the button clicked
        if(event.getSource() instanceof Button) {
            Button btn = (Button)event.getSource();

            if(isOperatorPressed) {
                txtCalculation.setText(btn.getText().trim());
            } else {
                txtCalculation.setText(txtCalculation.getText().trim() + btn.getText().trim());
            }

            isOperatorPressed = false;
        }

    }

    @FXML
    void clearOnAction(ActionEvent event) {
        //checks if the input data length is > 0 then it can be removed from the text field
        if(txtCalculation.getText().length() > 0) {
            txtCalculation.setText(txtCalculation.getText(0, txtCalculation.getText().length() - 1));
        }

    }


    @FXML
    //this method clears all the input data in the text field
    void clearAllOnAction(ActionEvent event) {
        txtCalculation.setText("");
        temp = 0.0; // resets the value of temp
        sum = 0.0; // resets the value of sum
        isOperatorPressed = false;
        operatorPressed = "";
    }

    @FXML
    void onOperatorClick(ActionEvent event) {

        if(event.getSource() instanceof Button) {

            Button btn = (Button)event.getSource();

            //here we check if the textfield id empty
            if (!txtCalculation.getText().isEmpty()) {

                //in temp we store the value of numbers input in the textfield
                temp = Double.valueOf(txtCalculation.getText());

                // operation with %
                if (btn.getText().equals("%")) {
                    temp = sum * temp / 100;
                }

                //depends of which operator is clicked we do the operation
                switch (operatorPressed) {
                    case "/":
                        sum /= temp;
                        break;
                    case "X":
                        sum *= temp;
                        break;
                    case "+":
                        sum += temp;
                        break;
                    case "-":
                        sum -= temp;
                        break;
                    default:
                        sum = temp;
                }
            }

            //if operator = or % is done we reset the value of operatorPressed
            if (btn.getText().equals("=") || btn.getText().equals("%")) {
                txtCalculation.setText(String.valueOf(sum));
                operatorPressed = "";
            } else {
                txtCalculation.setText("");
                operatorPressed = btn.getText().trim();
            }

            isOperatorPressed = true;
        }
    }

    @FXML
    void quitOnAction(ActionEvent event) {
            System.exit(0);
    }

    @FXML
    void initialize() {
        assert txtCalculation != null : "fx:id=\"txtCalculation\" was not injected: check your FXML file 'sample.fxml'.";
    }
}
