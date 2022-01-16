package grovre.java.GameShowcase;

import grovre.java.Deck;

public class Game {

    // Draws a random card from a deck. If it's greater, then you win
    public static void main(String[] args) {

        // Make a randomized deck with face cards that are not the same value, and create a players array
        Deck d = new Deck(false, true);
        Player player1 = new Player(d.getTopOfDeck(), "Jack");
        Player player2 = new Player(d.getTopOfDeck(), "Jill");
        System.out.println(player1.getName() + " has " + player1.getCard().toStringClean());
        System.out.println(player2.getName() + " has " + player2.getCard().toStringClean());

        // Compares card values and prints the winner
        int comparedNumber = player1.getCard().compareValues(player2.getCard());
        if (comparedNumber > 0) {
            System.out.println(player1.getName() + " wins by " + Math.abs(comparedNumber));
        } else if (comparedNumber < 0) {
            System.out.println(player2.getName() + " wins by " + Math.abs(comparedNumber));
        } else {
            System.out.println("Tie!");
        }
    }

}

