import java.util.ArrayList;
import java.util.Random;

public class Player {

	private int diceDoubleCount;
	private int getOutOfJailCout;
	private ArrayList<String> hand;

	public Player() {
		hand = new ArrayList<String>();
		diceDoubleCount = 0;
		getOutOfJailCout = 0;

	}

	/**
	 * Adds card to hand array for cards that aren't discarded
	 * @param card
	 */
	public void keepCard(String card) {
		hand.add(card);
		getOutOfJailCout++;
	}

	/**
	 *  Checks if hand list is empty
	 * @return true if empty
	 */
	public boolean isEmptyHand() {
		return hand.isEmpty();
	}

	/**
	 * Removes card that is being used from hand list
	 * 
	 * @return cards that is being used 
	 */
	public String useCard() {
		String card = hand.get(0);
		hand.remove(0);
		return card;
	}
	
	/**
	 * Generates 2 random numbers added between [1,7) evaluates
	 * them to see if they are the same number if so diceDoubleCount 
	 * goes up.
	 * 
	 * @return total moves taken 
	 */
	public int rollDice() {
		Random rand = new Random();
		int low = 1;
		int high = 6;

		int result1 = rand.nextInt(high - low) + low;
		int result2 = rand.nextInt(high - low) + low;

		if (result1 == result2) {
			diceDoubleCount++;

		}
		else {
			resetDiceDoubleCount();
		}

		return result1 + result2;
	}
	
	public void resetDiceDoubleCount() {
		diceDoubleCount = 0;
	}

	public int getDiceDoubleCount() {
		return diceDoubleCount;
	}

}
