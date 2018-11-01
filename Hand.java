package pontwon;

/**
 * @author 14001835
 */
public class Hand {

    int handTotal = 0;
    Cards card = new Cards();

    public Hand() {

    }

    public int handTotal(int total, String newCard) {
        handTotal = total + card.cardValue(newCard);
        return handTotal;
    }

    public String addToHand() {
        String newCard = card.drawCard();
        return newCard;
    }
}
