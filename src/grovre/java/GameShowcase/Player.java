package grovre.java.GameShowcase;

import grovre.java.Card;

// Player class that holds each player's card pretty much, proof of something I guess
class Player {

    private Card card;
    private String name;

    public Player(Card card, String name) {
        this.card = card;
        this.name = name;
    }

    // Getters and setters below

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setName(String name) {
        this.name = name;
    }
}
