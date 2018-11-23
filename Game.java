package pontwon;

import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author 14001835
 */
public class Game {

    int currentTotal;
    int dealerTotal;
    boolean gameRunning = true;
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();
    boolean bust = false;
    VBox layout = new VBox(10);

    public Game() {

        currentTotal = playerHand.handTotal(0, playerHand.addToHand());
        currentTotal = playerHand.handTotal(currentTotal, playerHand.addToHand());
        System.out.println("Starting total: " + currentTotal);

        dealerTotal = dealerHand.handTotal(0, dealerHand.addToHand());
        dealerTotal = dealerHand.handTotal(dealerTotal, dealerHand.addToHand());

    }

    public void display() {
        Stage window = new Stage();

        Button stickButton = new Button("Stick");
        Button twistButton = new Button("Twist");
        Label currentTotalLabel = new Label("Current total: " + currentTotal);
        
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(currentTotalLabel,twistButton, stickButton);

        Scene appScene2 = new Scene(layout, 500, 500);
        window.setScene(appScene2);
        window.show();

        stickButton.setOnAction(value -> {

            gameCheck(currentTotal);
            gameEnd(currentTotal, dealerTotal);
            //window.close();
        });

        twistButton.setOnAction(value -> {

            currentTotal = playerHand.handTotal(currentTotal, playerHand.addToHand());
            currentTotalLabel.setText("Current total: " + currentTotal);
            gameCheck(currentTotal);

        });

    }

    public void gameCheck(int player) {

        if (player > 21) {
            bust = true;
            gameEnd(currentTotal, dealerTotal);
        }
        if (player == 21) {
            bust = false;
            gameEnd(currentTotal, dealerTotal);
        }

    }

    public void gameEnd(int player, int dealer) {
        
        Label playerEndTotal = new Label("Your final total is: " + player);
        Label dealerEndTotal = new Label("The dealer's total is: " + dealer);
        Label resultMessage = new Label();
        
        layout.getChildren().addAll(playerEndTotal,dealerEndTotal);

        if (player < dealer && bust == false) {
            resultMessage.setText("The dealer's is higher! You lose...");
        } else if (player == dealer) {
            resultMessage.setText("The game is a draw!");
        } else if (player > dealer && dealer < 22 && bust == false) {
            resultMessage.setText("You have the higher total! You win!");
        } else if (bust == true) {
            resultMessage.setText("You have gone bust... You lose");
        }
        layout.getChildren().add(resultMessage);
    }
}
