package grovre.java;

import grovre.java.suits.Club;
import grovre.java.suits.Diamond;
import grovre.java.suits.Heart;
import grovre.java.suits.Spade;

import java.util.Arrays;

public class Deck {

    private final Card[] deck;
    private int topOfDeckIndex = 0;

    public Deck() {
        deck = generateNewDeck(false);
    }

    public Deck(boolean faceCardsAllEqual10) {
        deck = generateNewDeck(faceCardsAllEqual10);
    }

    public Deck(boolean faceCardsAllEqual10, boolean randomizeDeck) {
        deck = generateNewDeck(faceCardsAllEqual10);
        if(randomizeDeck) randomizeDeck();
    }

    public Card[] generateNewDeck(boolean faceCardsAllEqual10) {
        Card[] tempDeck = new Card[52];
        for (int i = 0; i < 13; i++) tempDeck[i] = new Spade(i, faceCardsAllEqual10);
        for (int i = 13; i < 13*2; i++) tempDeck[i] = new Club(i-13, faceCardsAllEqual10);
        for (int i = 13*2; i < 13*3; i++) tempDeck[i] = new Heart(i-13*2, faceCardsAllEqual10);
        for (int i = 13*3; i < 13*4; i++) tempDeck[i] = new Diamond(i-13*3, faceCardsAllEqual10);
        return tempDeck;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + Arrays.toString(deck) +
                ", topOfDeckIndex=" + topOfDeckIndex +
                '}';
    }

    public String toStringClean() {
        StringBuilder str = new StringBuilder(deck[0].toStringClean());
        for(int i = 1; i < deck.length; i++) {
            str.append(", ").append(deck[i].toStringClean());
        }
        return str.toString();
    }

    public static String toStringClean(Card[] cardArray) {
        StringBuilder str = new StringBuilder(cardArray[0].toStringClean());
        for(int i = 1; i < cardArray.length; i++) {
            str.append(", ").append(cardArray[i].toStringClean());
        }
        return str.toString();
    }

    public Card[] getDeck() {
        return deck;
    }

    public void aceIsHigh() { // Should only be used when no other card values are changed... Which is normally all the time
        for(Card c : deck) {
            if(c.getVALUE() == 1) c.setVALUE(11);
        }
    }

    public void aceIsLow() { // Should only be used when no other card values are changed... Which is normally all the time
        for(Card c : deck) {
            if(c.getVALUE() == 11) c.setVALUE(1);
        }
    }

    public void aceIs(int oldValue, int newValue) {
        for(Card c : deck) {
            if(c.getVALUE() == oldValue && c.getVALUE_ORDER() == 1) c.setVALUE(newValue);
        }
    }

    public void randomizeDeck() {
        for(int i = 0; i < deck.length; i++) {
            Card tempCard = deck[i];
            int tempIndex = (int) (Math.random() * deck.length);
            deck[i] = deck[tempIndex];
            deck[tempIndex] = tempCard;
        }
        topOfDeckIndex = 0;
    }

    public void shuffleDeck() {
        randomizeDeck();
        setTopOfDeckIndex(0);
    }

    public void setTopOfDeckIndex(int topOfDeckIndex) {
        this.topOfDeckIndex = topOfDeckIndex;
    }

    public int getTopOfDeckIndex() {
        return topOfDeckIndex;
    }

    public Card takeTopOfDeck() {
        topOfDeckIndex++;
        return deck[topOfDeckIndex-1];
    }

    public Card getTopOfDeck() {
        return takeTopOfDeck();
    }

    public void moveTopCardTo(int deckIndex) {
        Card temp = deck[topOfDeckIndex];
        if (deckIndex - topOfDeckIndex >= 0)
            System.arraycopy(deck, topOfDeckIndex + 1, deck, topOfDeckIndex, deckIndex - topOfDeckIndex);
        deck[deckIndex] = temp;
    }

    public void swapTopCardWith(int indexOfCardToSwap) {
        Card temp = deck[topOfDeckIndex];
        deck[topOfDeckIndex] = deck[indexOfCardToSwap];
        deck[indexOfCardToSwap] = temp;
    }

    public void swapCards(int firstIndex, int secondIndex) {
        Card temp = deck[firstIndex];
        deck[firstIndex] = deck[secondIndex];
        deck[secondIndex] = temp;
    }

    public int getIndexOfCard(int valueOrder, int suitOrder) {
        for(int i = 0; i < deck.length; i++) {
            Card c = deck[i];
            if(c.getVALUE_ORDER() == valueOrder && c.getSUIT_ORDER() == suitOrder) return i;
        }
        System.out.println("Card type doesn't exist.");
        System.out.println("You requested suit: " + suitOrder + ". Available: 1-4.");
        System.out.println("You requested value: " + valueOrder + ". Available: 1-13");
        return -1;
    }

    public Card getCardAtIndex(int indexOfCard) {
        return deck[indexOfCard];
    }

    public Card[] getDeckRange(int firstIndex, int lastIndex) {
        return Arrays.copyOfRange(deck, firstIndex, lastIndex);
    }

    public Card getRandomCardFromDeck() {
        return deck[(int) (Math.random() * deck.length)];
    }
}
