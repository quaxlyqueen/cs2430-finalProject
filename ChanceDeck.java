import java.util.ArrayList;
import java.util.Collections;

public class ChanceDeck {

	private ArrayList<String> chanceCard;
	private ArrayList<String> discard;

	public ChanceDeck() {
		chanceCard = new ArrayList<String>();
		discard = new ArrayList<String>();

		chanceCard.add("Advance to Boardwalk");
		chanceCard.add("Advance to Illinois Avenue");
		chanceCard.add("Advance to St. Charles Place");
		chanceCard.add("Advance to the nearest Railroad");

		chanceCard.add("Advance token to nearest Utility");
		chanceCard.add("Bank pays you dividend");
		chanceCard.add("Get Out of Jail Free");
		chanceCard.add("Go Back 3 Spaces");

		chanceCard.add("Go to Jail");
		chanceCard.add("Make general repairs on all your property");
		chanceCard.add("Speeding fine ");
		chanceCard.add("Take a trip to Reading Railroad");

		chanceCard.add("You have been elected Chairman of the Board");
		chanceCard.add("Your building loan matures");

		shuffle();
	}

	/**
	 * Shuffles deck 
	 */
	private void shuffle() {
		Collections.shuffle(chanceCard);
	}

	/**
	 * gets first item in array removes it from array.
	 * 
	 * @return top of card in deck
	 */
	public String drawChanceCard() {
		String temp = chanceCard.get(0);
		chanceCard.remove(0);
		return temp;
	}

	/**
	 * Gets card from player puts it in discard list
	 * 
	 * @param d
	 */
	public void discardChance(String d) {
		discard.add(d);
	}

	/**
	 * Adds all card in the discard list to chanceCard list
	 * discard list is cleared
	 * the is shuffled. 
	 */
	public void replenishChance() {
		chanceCard = new ArrayList<String>(discard);
		discard.clear();
		shuffle();
	}

	/**
	 *  checks to see if communityCard is empty
	 * @return true if empty
	 */
	public boolean isEmptyChanceDeck() {
		return chanceCard.isEmpty();

	}

	/**
	 *  checks to see if "Get Out of Jail Free" is in the
	 *  chanceCard and discard list 
	 *  
	 * @return true if "Get Out of Jail Free" is in deck 
	 */

	public boolean containsGetOutJail() {

		return chanceCard.contains("Get Out of Jail Free");
	}

}
