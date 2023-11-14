import java.util.ArrayList;
import java.util.Collections;

public class CommunityChestDeck {

	private ArrayList<String> communityCard;
	private ArrayList<String> discard;

	public CommunityChestDeck() {
		communityCard = new ArrayList<String>();
		discard = new ArrayList<String>();

		communityCard.add("Advance to Go");
		communityCard.add("Bank error in your favor");
		communityCard.add("Doctor’s fee");
		communityCard.add("Sale of stock");
		communityCard.add("Get Out of Jail Free");
		communityCard.add("Go to Jail");
		communityCard.add("Holiday fund matures");
		communityCard.add("Income tax refund");
		communityCard.add("It is your birthday");
		communityCard.add("Life insurance matures");
		communityCard.add("Pay hospital fees");
		communityCard.add("Pay school fees");
		communityCard.add("Consultancy fee");
		communityCard.add("You are assessed for street repair");
		communityCard.add("You have won second prize in a beauty contest");
		communityCard.add("You inherit");
		shuffle();
	}

	/**
	 * Shuffles deck 
	 */
	private void shuffle() {
		Collections.shuffle(communityCard);
	}

	/**
	 * gets first item in array removes it from array.
	 * 
	 * @return top of card in deck
	 */
	public String drawComunityCard() {
		String temp = communityCard.get(0);
		communityCard.remove(0);
		return temp;
	}

	/**
	 * Gets card from player puts it in discard list
	 * 
	 * @param d
	 */
	public void discardCommunityCard(String d) {
		discard.add(d);
	}

	/**
	 * Adds all card in the discard list to communityCard list
	 * discard list is cleared
	 * the is shuffled. 
	 */
	public void replenishCommunityDeck() {
		communityCard = new ArrayList<String>(discard);
		discard.clear();
		shuffle();
	}

	/**
	 *  checks to see if communityCard is empty
	 * @return true if empty
	 */
	public boolean isEmptyComunityDeck() {
		return communityCard.isEmpty();
	}

	/**
	 *  checks to see if "Get Out of Jail Free" is in the
	 *  communityCard and discard list 
	 *  
	 * @return true if "Get Out of Jail Free" is in deck 
	 */
	public boolean containsGetOutJail() {
		return communityCard.contains("Get Out of Jail Free") && discard.contains("Get Out of Jail Free");
	}

}
