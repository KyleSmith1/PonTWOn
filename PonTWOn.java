package pontwon;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author 14001835
 */
public class PonTWOn extends Application {

    public void start(Stage stage) throws IOException {

        StackPane componentLayout = new StackPane();
        componentLayout.setPadding(new Insets(20, 0, 20, 20));

        Scene appScene = new Scene(componentLayout, 500, 500);
        stage.setScene(appScene);
        stage.show();

        Button startButton = new Button("Start Game");
        componentLayout.getChildren().add(startButton);
        startButton.setOnAction(value ->{
            
            Game newGame = new Game();
            newGame.display();

        });

    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }

}
