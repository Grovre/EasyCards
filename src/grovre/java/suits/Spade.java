package grovre.java.suits;

import grovre.java.Card;

public class Spade extends Card {

    public Spade(int value, boolean faceCardsAllEqual10) {
        super(value, faceCardsAllEqual10);
        SUIT_SHOW = "♠";
        SUIT_ORDER = 4;
    }

    public Spade(int value, boolean faceCardsAllEqual10, int suitOrder) {
        super(value, faceCardsAllEqual10);
        SUIT_SHOW = "♠";
        SUIT_ORDER = suitOrder;
    }
}
