package grovre.java.suits;

import grovre.java.Card;

public class Diamond extends Card {

    public Diamond(int value, boolean faceCardsAllEqual10) {
        super(value, faceCardsAllEqual10);
        SUIT_SHOW = "♦";
        SUIT_ORDER = 2;
    }

    public Diamond(int value, boolean faceCardsAllEqual10, int suitOrder) {
        super(value, faceCardsAllEqual10);
        SUIT_SHOW = "♦";
        SUIT_ORDER = suitOrder;
    }
}
