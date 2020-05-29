package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import provider.Wrapper;      // import the other class


public class Controller {
    private Alert messageBox;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRandom;

    @FXML
    private Button btnSubset;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnRandomOnAction(ActionEvent event) {
//        txtSeed = new TextField();
//        txtSize = new TextField();
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        ActionHandlerClass actionHandler = new ActionHandlerClass();
        btnRandom.setOnAction(actionHandler);
       // txtSize.setOnAction(actionHandler);
    }

    @FXML
    void btnSubsetOnAction(ActionEvent event) {
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        ActionHandlerClass actionHandler = new ActionHandlerClass();
        btnSubset.setOnAction(actionHandler);
    }

    @FXML
    void initialize() {
        assert btnRandom != null : "fx:id=\"btnRandom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSubset != null : "fx:id=\"btnSubset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    private class ActionHandlerClass implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            String string = "";
            int size = Integer.parseInt(txtSize.getText());
            Wrapper test = new Wrapper(size);
            int seed = Integer.parseInt(txtSeed.getText());
            // user pressed Enter in txtInputField
            if (event.getSource() == btnSubset) {
              //  test.makeFixedSelection();
                string = "Chars: " + test.makeFixedSelection().getSecretChars(seed);
            } // user pressed Enter in txtInputFieldWithPrompt
            else if (event.getSource() == btnRandom) {
                string = "Chars: " + test.makeFixedSelection().getSecretChars(seed);
            }

            // display content of the currently active textfield
            messageBox.setTitle("Input text");
            messageBox.setHeaderText("Count of distinct chars");
            messageBox.setContentText(string);
            messageBox.showAndWait();
        }
    }
}
