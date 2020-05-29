package f71863.test1.view;

import java.net.URL;
import java.util.ResourceBundle;

import f71863.test1.model.Card;
import f71863.test1.model.DeckOfCards;
import f71863.test1.model.Faces;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameSceneController {
    DeckOfCards deck; // реферира обект от DeckOfCards
    int[] countFaces; // масив от броячи на сили на карти в една ръка
    Faces face;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDealCards;

    @FXML
    private TextArea txtDealCards;

    @FXML
    private Button btnSameFace;

    @FXML
    private TextArea txtSameFace;

    @FXML
    void btnDealCardsOnAction(ActionEvent event) {
        //btnDealCards.setOnAction();
        //DeckOfCards.dealSeven();
        txtDealCards.setText("test");
    }

    @FXML
    void btnSameFace(ActionEvent event) {
        txtDealCards.setText("test");
    }

    void countHand(Card[] hand) {
        int count = 0;

        for (int i = 0; i<hand.length; i++) {
            if (hand[i] == null) {
                System.out.println("Empty");
            } else {
                count++;
            }

        }
    }

    @FXML
    void initialize() {
        assert btnDealCards != null : "fx:id=\"btnDealCards\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert txtDealCards != null : "fx:id=\"txtDealCards\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert btnSameFace != null : "fx:id=\"btnSameFace\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert txtSameFace != null : "fx:id=\"txtSameFace\" was not injected: check your FXML file 'GameScene.fxml'.";

    }
}
