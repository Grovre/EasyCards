package grovre.java;

import grovre.java.suits.Club;
import grovre.java.suits.Diamond;
import grovre.java.suits.Heart;
import grovre.java.suits.Spade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

    private final ArrayList<Card> deck;
    private int topOfDeckIndex = 0;

    public Deck() {
        deck = generateNewDeck(false);
    }

    public Deck(boolean faceCardsAllEqual10) {
        deck = generateNewDeck(faceCardsAllEqual10);
    }

    public Deck(boolean faceCardsAllEqual10, boolean randomizeDeck) {
        deck = generateNewDeck(faceCardsAllEqual10);
        if (randomizeDeck) randomizeDeck();
    }

    public static String toStringClean(ArrayList<Card> cardList) {
        StringBuilder str = new StringBuilder(cardList.get(0).toStringClean());
        for (int i = 1; i < cardList.size(); i++) {
            str.append(", ").append(cardList.get(i).toStringClean());
        }
        return str.toString();
    }

    // TODO: 2/26/22 Improve deck generation now that this no longer uses arrays but a list instead
    public ArrayList<Card> generateNewDeck(boolean faceCardsAllEqual10) {
        Card[] tempDeck = new Card[52];
        for (int i = 0; i < 13; i++) tempDeck[i] = new Spade(i, faceCardsAllEqual10);
        for (int i = 13; i < 13 * 2; i++) tempDeck[i] = new Club(i - 13, faceCardsAllEqual10);
        for (int i = 13 * 2; i < 13 * 3; i++) tempDeck[i] = new Heart(i - 13 * 2, faceCardsAllEqual10);
        for (int i = 13 * 3; i < 13 * 4; i++) tempDeck[i] = new Diamond(i - 13 * 3, faceCardsAllEqual10);
        ArrayList<Card> toBeReturned = new ArrayList<>(tempDeck.length);
        toBeReturned.addAll(Arrays.asList(tempDeck));
        return toBeReturned;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck.toString() +
                '}';
    }

    public String toStringClean() {
        StringBuilder str = new StringBuilder(deck.get(0).toStringClean());
        for (int i = 1; i < deck.size(); i++) {
            str.append(", ").append(deck.get(i).toStringClean());
        }
        return str.toString();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void aceIsHigh() { // Should only be used when no other card values are changed... Which is normally all the time
        for (Card c : deck) {
            if (c.getVALUE() == 1) c.setVALUE(11);
        }
    }

    public void aceIsLow() { // Should only be used when no other card values are changed... Which is normally all the time
        for (Card c : deck) {
            if (c.getVALUE() == 11) c.setVALUE(1);
        }
    }

    public void aceIs(int oldValue, int newValue) {
        for (Card c : deck) {
            if (c.getVALUE() == oldValue && c.getVALUE_ORDER() == 1) c.setVALUE(newValue);
        }
    }

    @Deprecated
    public void randomizeDeck() {
        for (int i = 0; i < deck.size(); i++) {
            Card tempCard = deck.get(i);
            int tempIndex = (int) (Math.random() * deck.size());
            deck.set(i, deck.get(tempIndex));
            deck.set(tempIndex, tempCard);
        }
        topOfDeckIndex = 0;
    }

    public void shuffleDeck() {
        randomizeDeck();
        setTopOfDeckIndex(0);
    }

    public void resetDeck() {
        shuffleDeck();
        setTopOfDeckIndex(0);
    }

    public int getTopOfDeckIndex() {
        return topOfDeckIndex;
    }

    public void setTopOfDeckIndex(int topOfDeckIndex) {
        this.topOfDeckIndex = topOfDeckIndex;
    }

    public Card takeTopOfDeck() {
        topOfDeckIndex++;
        return deck.get(topOfDeckIndex - 1);
    }

    public Card getTopOfDeck() {
        return takeTopOfDeck();
    }

    public void moveTopCardTo(int deckIndex) {
        Card temp = deck.remove(topOfDeckIndex);
        topOfDeckIndex--;
        deck.add(deckIndex, temp);
    }

    public void swapTopCardWith(int indexOfCardToSwap) {
        Card temp = deck.get(topOfDeckIndex);
        deck.set(topOfDeckIndex, deck.get(indexOfCardToSwap));
        deck.set(indexOfCardToSwap, temp);
    }

    public void swapCards(int firstIndex, int secondIndex) {
        Card temp = deck.get(firstIndex);
        deck.set(firstIndex, deck.get(secondIndex));
        deck.set(secondIndex, temp);
    }

    // TODO: 2/26/22 Revisit and make this method better
    public int getIndexOfCard(int valueOrder, int suitOrder) {
        for (int i = 0; i < deck.size(); i++) {
            Card c = deck.get(i);
            if (c.getVALUE_ORDER() == valueOrder && c.getSUIT_ORDER() == suitOrder) return i;
        }
        System.out.println("Card type doesn't exist.");
        System.out.println("You requested suit: " + suitOrder + ". Available: 1-4.");
        System.out.println("You requested value: " + valueOrder + ". Available: 1-13");
        return -1;
    }

    public Card getCardAtIndex(int indexOfCard) {
        return deck.get(indexOfCard);
    }

    public ArrayList<Card> getDeckRange(int firstIndex, int lastIndex) {
        return new ArrayList<>(deck.subList(firstIndex, lastIndex));
    }

    public Card getRandomCardFromDeck() {
        return deck.get(new Random().nextInt(deck.size()));
    }
}
