package pontwon;

import java.util.ArrayList;

/**
 * @author 14001835
 */
public class Hand {

    int handTotal = 0;
    Cards card = new Cards();
    ArrayList<String> currentHand = new ArrayList<>();

    public Hand() {

    }

    public int handTotal(int total, String newCard) {
        handTotal = total + card.cardValue(newCard);
        return handTotal;
    }

    public String addToHand() {
        String newCard = card.drawCard();
        currentHand.add(newCard);
        return newCard;
    }

    public String displayHand() {

        String handString = String.join(",", currentHand);
        return handString;

    }
}
