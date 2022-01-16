package grovre.java.suits;

import grovre.java.Card;

public class Club extends Card {

    public Club(int value, boolean faceCardsAllEqual10) {
        super(value, faceCardsAllEqual10);
        SUIT_SHOW = "♣";
        SUIT_ORDER = 1;
    }

    public Club(int value, boolean faceCardsAllEqual10, int suitOrder) {
        super(value, faceCardsAllEqual10);
        SUIT_SHOW = "♣";
        SUIT_ORDER = suitOrder;
    }
}
