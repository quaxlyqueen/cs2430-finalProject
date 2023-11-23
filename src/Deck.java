import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {
	ArrayList<Card> cards;

	public Deck(String filename) {
		// Create the deck by reading in the file.
		cards = new ArrayList<Card>();
		try {

			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				String action = scanner.nextLine();
				Card newCard = new Card(action);
				cards.add(newCard);
			}
		} catch (Exception e) {
			System.out.println("Can't find comCard.txt!");
		}

	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}

	private void shuffle() {
		Collections.shuffle(cards);
	}

	public String drawChance() {

		return ""; // TODO: Return the action of the card drawn
	}

	public String drawCommunity() {

		Random random = new Random();
		int randomNumber = random.nextInt(16);
		return getCardAction(randomNumber); // TODO: Return the action of the card drawn
	}

	public String getCardAction(int index) {
		if (index >= 0 && index < cards.size()) {
			return cards.get(index).action;
		} else {
			return "Invalid index";
		}
	}

	public int getNumberOfCards() {
		return cards.size();
	}

	private class Card {
		String action;

		public Card(String action) {
			this.action = action;

		}

	}

	public static void main(String[] args) {
		// Create a Deck object by providing the filename
		Deck deck = new Deck("src/comCard.txt");
		String action = deck.drawCommunity();
		System.out.println(action);

	}
}
