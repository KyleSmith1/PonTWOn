package pontwon;

import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(twistButton, stickButton);

        Scene appScene2 = new Scene(layout, 500, 500);
        window.setScene(appScene2);
        window.show();

        stickButton.setOnAction(value -> {

            gameCheck(currentTotal);
            gameEnd(currentTotal, dealerTotal);
            window.hide();
        });

        twistButton.setOnAction(value -> {

            currentTotal = playerHand.handTotal(currentTotal, playerHand.addToHand());
            System.out.println("New total: " + currentTotal);
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
        System.out.println("Your final total is: " + player);
        System.out.println("The dealer's total is: " + dealer);

        if (player < dealer && bust == false) {
            System.out.println("The dealer's is higher! You lose...");
        } else if (player == dealer) {
            System.out.println("The game is a draw!");
        } else if (player > dealer && dealer < 22 && bust == false) {
            System.out.println("You have the higher total! You win!");
        } else if (bust == true) {
            System.out.println("You have gone bust... You lose");
        }
    }
}
