package pontwon;

import java.util.Scanner;

/**
 * @author 14001835
 */
public class Game {

    int currentTotal;
    int dealerTotal;
    boolean gameRunning = true;

    public Game() {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        currentTotal = playerHand.handTotal(0, playerHand.addToHand());
        currentTotal = playerHand.handTotal(currentTotal, playerHand.addToHand());
        System.out.println("Starting total: " + currentTotal);

        dealerTotal = dealerHand.handTotal(0, dealerHand.addToHand());
        dealerTotal = dealerHand.handTotal(dealerTotal, dealerHand.addToHand());

        String choice;
        Scanner kboard = new Scanner(System.in);
        System.out.println("Stick or Twist?");
        choice = kboard.nextLine();

        switch (choice.toLowerCase()) {
            case "stick":
                gameCheck(currentTotal,dealerTotal);
                break;
            case "twist":
                currentTotal = playerHand.handTotal(currentTotal, playerHand.addToHand());
                System.out.println("New total: " + currentTotal);
                gameCheck(currentTotal,dealerTotal);
                break;
            default:
                System.out.println("Input not recognised...");
                break;

        }

    }

    public void gameCheck(int player, int dealer) {
        if (player > 21) {
            System.out.println("You have gone bust!");
        } else {
            System.out.println("Your final total is: " + player);
            System.out.println("The dealer's total is: " + dealer);
            if (player < dealer) {
                System.out.println("The dealer's is higher! You lose...");
            } else if (player == dealer) {
                System.out.println("The game is a draw!");
            } else {
                System.out.println("You have the higher total! You win!");
            }
        }
    }
}
