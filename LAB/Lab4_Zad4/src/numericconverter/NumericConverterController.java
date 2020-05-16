package numericconverter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class NumericConverterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDecimal;

    @FXML
    private Button btnHex;

    @FXML
    private Button btnBinary;

    @FXML
    private TextField txtDecimal;

    @FXML
    private TextField txtHex;

    @FXML
    private TextField txtBinary;

    @FXML
    private MenuBar mnu;

    @FXML
    private Menu mnuConvert;

    @FXML
    private MenuItem mnuConvertDecimal;

    @FXML
    private MenuItem mnuConvertHex;

    @FXML
    private MenuItem mnuConvertBinary;

    @FXML
    private Menu mnuQuit;

    @FXML
    private MenuItem mnuQuitExit;

    @FXML
    void mnuConvertBinaryOnAction(ActionEvent event) {
        //from binary to hex
        if (!txtBinary.getText().isEmpty()) {
            int binary = Integer.parseInt(txtBinary.getText());
            int decimal = Integer.parseInt(String.valueOf(binary),2);
            String hexStr = Integer.toString(decimal,16);
            txtHex.setText(hexStr);
            txtDecimal.setText(String.valueOf(decimal));
        }
    }

    @FXML
    void mnuConvertDecimalOnAction(ActionEvent event) {
        if (!txtDecimal.getText().isEmpty()) {
            String decimalToHex = Integer.toHexString(Integer.parseInt(txtDecimal.getText()));
            String decimalToBinary = Integer.toBinaryString(Integer.parseInt(txtDecimal.getText()));
            txtHex.setText(decimalToHex);
            txtBinary.setText(decimalToBinary);
        }
    }

    @FXML
    void mnuConvertHexOnAction(ActionEvent event) {
        if (!txtHex.getText().isEmpty()) {
            int hexToDecimal = Integer.parseInt(txtHex.getText().trim(), 16 );
            String hexToBinary = Integer.toBinaryString(hexToDecimal);
            txtDecimal.setText(String.valueOf(hexToDecimal));
            txtBinary.setText(hexToBinary);
        }

    }

    @FXML
    void mnuQuitExitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void mnuQuitOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDecimal != null : "fx:id=\"btnDecimal\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert btnHex != null : "fx:id=\"btnHex\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert btnBinary != null : "fx:id=\"btnBinary\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert txtDecimal != null : "fx:id=\"txtDecimal\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert txtHex != null : "fx:id=\"txtHex\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert txtBinary != null : "fx:id=\"txtBinary\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert mnu != null : "fx:id=\"mnu\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert mnuConvert != null : "fx:id=\"mnuConvert\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert mnuConvertDecimal != null : "fx:id=\"mnuConvertDecimal\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert mnuConvertHex != null : "fx:id=\"mnuConvertHex\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert mnuConvertBinary != null : "fx:id=\"mnuConvertBinary\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert mnuQuit != null : "fx:id=\"mnuQuit\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";
        assert mnuQuitExit != null : "fx:id=\"mnuQuitExit\" was not injected: check your FXML file 'FXMLNumericConverter.fxml'.";

    }
}
