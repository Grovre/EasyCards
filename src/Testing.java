import grovre.java.*;

public class Testing {

    public static void main(String[] args) {
        Deck d = new Deck(false, false);
        System.out.println(d);
        System.out.println();

        for(Card c : d.getDeck()) {
            String suit = c.getSUIT_SHOW();
            System.out.println(suit + " " + c.getCardType() + " : " + c.getCardTypeInString() + " " + suit);
        }
    }

}
