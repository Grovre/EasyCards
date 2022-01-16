package grovre.java;

public class MethodsShowcase {

    public static void main(String[] args) {

        Deck d = new Deck(true, false);
        // Create a deck with all face cards equalling the same! Games where face cards are of the same value can be played! Order of the cards is kept in VALUE_ORDER if you ever need the order!
        System.out.println("Face card values are the same, example:");
        System.out.println(d.toStringClean());

        // Clean toString methods, so you only show what someone would see in real life, the card number and its suit! One for printing the whole deck as a Deck method or for printing an individual card as a Card method! As shown below
        // Also comes static if you ever have your own array of cards!
        System.out.println();
        System.out.println("Single clean card string:");
        System.out.println(d.getRandomCardFromDeck().toStringClean());
        System.out.println("Deck clean string:");
        System.out.println(d.toStringClean());

        // Generate a new deck whenever you need another by just making a new deck object!
        System.out.println();
        System.out.println("Generating a new deck is easy:");
        System.out.println("Old deck:");
        d.randomizeDeck();
        System.out.println(d.toStringClean());
        System.out.println("New deck:");
        d = new Deck(true, false);
        System.out.println(d.toStringClean());

        // Is the value of an ace 1? Or did it turn into 11? Call the method to change its value to 1 or 11!
        System.out.println();
        System.out.println("Here's a regular ace of spades along with its value:");
        Card c = d.getCardAtIndex(0);
        System.out.println(c.toStringClean() + "; value = " + c.getVALUE());
        System.out.println("Here's that same card when ace is high:");
        d.aceIsHigh();
        System.out.println(c.toStringClean() + "; value = " + c.getVALUE());
        System.out.println("But let's keep it low...:");
        d.aceIsLow();
        System.out.println(c.toStringClean() + "; value = " + c.getVALUE());
        System.out.println("Or you can set it to whatever you want ace to be!");
        d.aceIs(1, Integer.MAX_VALUE);
        System.out.println(c.toStringClean() + "; value = " + c.getVALUE() + "; The max integer value!");

        // Need to randomize your deck on the go? No need to fear a riffle shuffle, this is definitely a good shuffle! Look at the code yourself!
        // Shuffling works by iterating through the deck and swapping the card at i with a random card from the deck. Cards can be swapped more than once.
        // Also called randomizeDeck()
        System.out.println();
        System.out.println("Shuffled deck example:");
        d = new Deck();
        d.shuffleDeck();
        System.out.println(d.toStringClean());

        // If you for any reason need to swap the card at the top of the deck with another card, well you can do that.
        System.out.println();
        System.out.println("Swapping the top card with any other card in the deck:");
        d = new Deck();
        Card[] firstFiveCards = d.getDeckRange(0,5);
        System.out.println("Here's the first five cards in a deck:\n" + Deck.toStringClean(firstFiveCards));
        d.swapTopCardWith(32);
        firstFiveCards = d.getDeckRange(0,5);
        System.out.println("Here's what they look like after switching the ace with with 4:\n" + Deck.toStringClean(firstFiveCards));
        System.out.println("It was swapped with a 7 of hearts!");

        // Need a range of cards from the deck? Try this method!
        System.out.println();
        System.out.println("Getting all of one suit from the deck:");
        d = new Deck();
        Card[] suitArray = d.getDeckRange(0,13);
        System.out.println(Deck.toStringClean(suitArray));
        System.out.println("Or even a different suit:");
        suitArray = d.getDeckRange(14,26);
        System.out.println(Deck.toStringClean(suitArray));

        // There are a few more swap methods and the ability to get a card's index and the index of a card
        // But of course, there's also a way to retrieve the card at the top of the deck (and it automatically will get the next card in the deck next time you call it too!)
        // The methods takeTopOfDeck and getTopOfDeck do the same thing but there's a lot of methods starting with get, and I didn't like that, so I made take.
        System.out.println();
        System.out.println("Here is a new deck:");
        d = new Deck();
        System.out.println(d.toStringClean());
        System.out.println("Here is the top card from that deck:");
        System.out.println(d.takeTopOfDeck().toStringClean());
        System.out.println("Here is the next card:");
        System.out.println(d.takeTopOfDeck().toStringClean());
        System.out.println("We can shuffle the deck and it'll still work! Here's the now-shuffled deck:");
        d.shuffleDeck();
        System.out.println(d.toStringClean());
        System.out.println("Here's the card at the top:");
        System.out.println(d.getTopOfDeck().toStringClean());
        System.out.println("And the next card in line:");
        System.out.println(d.takeTopOfDeck().toStringClean());

        // Cards also have their own methods, many similar to deck! Have fun!

    }
}
