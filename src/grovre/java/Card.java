package grovre.java;

public class Card {

    protected String VALUE_SHOW; // String values, what people normally see with real cards
    protected String SUIT_SHOW;
    protected int VALUE_ORDER; // The order of cards, like 1 -> 2 -> 3 -> ... -> 10 -> J -> Q etc.
    protected int SUIT_ORDER;
    protected int VALUE; // True value of a card, A can be 1 or 11 and all other cards are 1-10. Can be changed
    protected int CARD_TYPE; // 0 for regular number, 1 :: ace, 2 :: jack, 3 :: queen, 4 :: king

    public Card(int value, boolean faceCardsAllEqual10) {
        VALUE_ORDER = value + 1;
        VALUE_SHOW = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}[value];
        this.VALUE = value + 1;
        setCardType(VALUE_ORDER);
        if (faceCardsAllEqual10 && VALUE_ORDER > 10) {
            this.VALUE = 10;
        }
    }

    private void setCardType(int value) {
        switch (value) {
            case 1, 14 -> {
                CARD_TYPE = 1;
            }
            case 11 -> {
                CARD_TYPE = 2;
            }
            case 12 -> {
                CARD_TYPE = 3;
            }
            case 13 -> {
                CARD_TYPE = 4;
            }
            default -> {
                CARD_TYPE = 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "VALUE=" + VALUE +
                ", VALUE_SHOW='" + VALUE_SHOW + '\'' +
                ", SUIT_SHOW='" + SUIT_SHOW + '\'' +
                ", VALUE_ORDER=" + VALUE_ORDER +
                ", SUIT_ORDER=" + SUIT_ORDER +
                ", CARD_TYPE= " + CARD_TYPE +
                '}';
    }

    public String toStringClean() {
        return "" + SUIT_SHOW + VALUE_SHOW;
    }

    // Returns an int of whether it's of a greater, less than or same
    public int compareValues(Card other) {
        return this.VALUE - other.VALUE;
    }

    // Returns an int of whether it's of a greater, less than or same suit. Classic order: Clubs = 1, Diamonds = 2, Hearts = 3, Spades = 4
    // If the int is negative, the card that called this method is smaller and the other card is greater. If 0, same suit
    public int compareSuits(Card other) {
        return this.SUIT_ORDER - other.SUIT_ORDER;
    }

    public String getVALUE_SHOW() {
        return VALUE_SHOW;
    }

    public int getCardType() {
        return CARD_TYPE;
    }

    public String getCardTypeInString() {
        return switch (CARD_TYPE) {
            case 1 -> "A";
            case 2 -> "J";
            case 3 -> "Q";
            case 4 -> "K";
            default -> "N";
        };
    }

    public String getSUIT_SHOW() {
        return SUIT_SHOW;
    }

    public int getVALUE_ORDER() {
        return VALUE_ORDER;
    }

    public void setVALUE_ORDER(int VALUE_ORDER) {
        this.VALUE_ORDER = VALUE_ORDER;
    }

    public int getSUIT_ORDER() {
        return SUIT_ORDER;
    }

    public int getVALUE() {
        return VALUE;
    }

    public void setVALUE(int VALUE) {
        this.VALUE = VALUE;
    }

}
