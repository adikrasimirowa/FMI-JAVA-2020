package f71863.test1.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
