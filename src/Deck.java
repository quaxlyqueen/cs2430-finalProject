import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static Random ran = new Random();
    ArrayList<Card> cards;

    public Deck(String filename) {
        cards = new ArrayList<Card>();

        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                cards.add(new Card(line));
            }
        } catch (Exception e) {
            System.out.println("Error loading deck: " + e.getMessage());
        }
    }

    private void printDeck() {
        for (Card card : cards) {
            System.out.println(card.action);
        }
    }

    public String draw() {
        int index = ran.nextInt(cards.size());
        return cards.remove(index).action;
    }

    private class Card {
        String action;

        public Card(String action) {
            this.action = action;
        }
    }
}
