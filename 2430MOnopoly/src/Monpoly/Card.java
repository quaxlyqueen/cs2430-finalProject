import java.util.ArrayList;
import java.util.Collections;

public class Card {
	private ArrayList<Card> chanceCards;
    private ArrayList<Card> communityChestCards;

    public Card() {
        chanceCards = new ArrayList<>();
        communityChestCards = new ArrayList<>();

        initializeChanceCards();
        initializeCommunityChestCards();

        shuffle();
    }

    public Card drawChanceCard() {
        return drawCard(chanceCards);
    }

    public Card drawCommunityChestCard() {
        return drawCard(communityChestCards);
    }

    public void returnCardToDeck(Card card) {
        // Return the drawn card to the bottom of the deck
        chanceCards.add(card);
        shuffle();
    }

    private void initializeChanceCards() {
        // Add chance cards to the deck
        // TODO: Add chance card details
    }

    private void initializeCommunityChestCards() {
        // Add community chest cards to the deck
        // TODO: Add community chest card details
    }

    private void shuffle() {
        // Shuffle both decks
        Collections.shuffle(chanceCards);
        Collections.shuffle(communityChestCards);
    }

    private Card drawCard(ArrayList<Card> deck) {
        if (deck.isEmpty()) {
            // Reshuffle the discard pile into the deck
            shuffle();
        }

        // Draw the top card
        return deck.remove(0);
    }
}
