package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import validators.EmailValidator;
import validators.PasswordValidator;
import validators.PhoneValidator;
import validators.UserNameValidator;

import javax.swing.*;

public class ControllerScene {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnValidate;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblConfirmPassword;

    @FXML
    private PasswordField txtPasswordConfirm;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhone;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnValidateOnAction(ActionEvent event) {

        if (!UserNameValidator.isValid(txtUsername.getText())) {
            lblUsername.setText("Wrong username");
        } else if (!EmailValidator.isValid(txtEmail.getText())) {
            lblEmail.setText("Wrong email");
        } else if (!PhoneValidator.isValid(txtPhone.getText())) {
            lblPhone.setText("Wrong phone");
        } else if (!PasswordValidator.isValid(txtPassword.getText())) {
            lblPassword.setText("Wrong password");
        }else if (!txtPassword.getText().equals(txtPasswordConfirm.getText())) {
            lblConfirmPassword.setText("Wrong password");
        }

    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'scene.fxml'.";
        assert btnValidate != null : "fx:id=\"btnValidate\" was not injected: check your FXML file 'scene.fxml'.";
        assert lblUsername != null : "fx:id=\"lblUsername\" was not injected: check your FXML file 'scene.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'scene.fxml'.";
        assert lblConfirmPassword != null : "fx:id=\"lblConfirmPassword\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'scene.fxml'.";

    }
}
