import java.util.Scanner;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Deck {
    ArrayList<Card> cards;

    public Deck(String filename) {
        // Create the deck by reading in the file.
    }

    @SuppressWarnings("unused")
	private void shuffle() {
        // Shuffle the deck
    }

    public String drawChance() {
        return ""; // TODO: Return the action of the card drawn
    }

    public String drawCommunity() {
        return ""; // TODO: Return the action of the card drawn
    }

    private class Card {
        String action;

        public Card(String action) {
            this.action = action;
        }
    }
}
