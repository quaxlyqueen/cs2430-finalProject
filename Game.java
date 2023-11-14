public class Game {


	private int turns, totalMoves;
	private Board bored;
	private Player player1;
	private CommunityChestDeck communityDeck;
	private ChanceDeck chanceDeck;

	public Game(int turns) {
		this.turns = turns;
		totalMoves = 0;
		bored = new Board();
		player1 = new Player();
		communityDeck = new CommunityChestDeck();
		chanceDeck = new ChanceDeck();
	}

	public void strategyA() {
		int moves;
		String location;

		for (int i = 0; i < turns; i++) {
			moves = player1.rollDice();
			totalMoves = +moves;
			bored.setJail(false);
			bored.move(moves);
			location = bored.getLocation();

			if (player1.getDiceDoubleCount() == 3) {
				bored.moveToJail();
			}

			if (location.contains("Chance")) {
				drawChanceCard();
			}
			else if (location.contains("Community Chest")) {
				drawCommunityCard();
			}
			else if (bored.getJail()) {
				if (!player1.isEmptyHand() && !communityDeck.containsGetOutJail()) {
					communityDeck.discardCommunityCard(player1.useCard());

				}
				else if (!player1.isEmptyHand() && !chanceDeck.containsGetOutJail()) {
					chanceDeck.discardChance(player1.useCard());
				}

			}
		}
	}

	public void strategyB() {
		int jailTurns = 0;
		int moves;
		String location;

		for (int i = 0; i < turns; i++) {
			moves = player1.rollDice();
			totalMoves = +moves;
			bored.setJail(false);
			bored.move(moves);
			location = bored.getLocation();

			if (player1.getDiceDoubleCount() == 3) {
				bored.moveToJail();
			}

			if (location.contains("Chance")) {
				drawChanceCard();
			}
			else if (location.contains("Community Chest")) {
				drawCommunityCard();
			}

			//System.out.print(location.contains("Jail"));
			if (bored.getJail()) {
				if (player1.isEmptyHand()) {
					player1.resetDiceDoubleCount();
					jailTurns = 0;

					while (jailTurns < 4 & i < turns) {
						player1.rollDice();
						i++;

						if (player1.getDiceDoubleCount() == 1) {
							bored.setJail(false);
							break;
						}

						bored.moveToJail();
					}
				}
				else if (!player1.isEmptyHand() && !communityDeck.containsGetOutJail()) {
					communityDeck.discardCommunityCard(player1.useCard());

				}
				else if (!player1.isEmptyHand() && !chanceDeck.containsGetOutJail()) {
					chanceDeck.discardChance(player1.useCard());
				}

			}
		}
	}

	private void drawChanceCard() {

		if (chanceDeck.isEmptyChanceDeck()) {
			chanceDeck.replenishChance();
			drawChanceCard();
		}

		String card = chanceDeck.drawChanceCard();

		switch (card) {
		case "Advance to Boardwalk":
			bored.moveToBoardwalk();
			chanceDeck.discardChance(card);
			break;

		case "Advance to Go":
			bored.moveToGo();
			chanceDeck.discardChance(card);
			break;

		case "Advance to Illinois Avenue":
			bored.moveToIllinoisAvenue();
			chanceDeck.discardChance(card);
			break;

		case "Advance to St. Charles Place":
			bored.moveToStCharlesPlace();
			chanceDeck.discardChance(card);
			break;

		case "Advance to the nearest Railroad":
			bored.moveToNearestRailroad();
			chanceDeck.discardChance(card);
			break;

		case "Advance token to nearest Utility":
			bored.moveToNearestUtility();
			chanceDeck.discardChance(card);
			break;

		case "Get Out of Jail Free":
			player1.keepCard(card);
			break;

		case "Go Back 3 Spaces":
			bored.moveBackThree();
			chanceDeck.discardChance(card);
			break;

		case "Go to Jail":
			bored.moveToJail();
			chanceDeck.discardChance(card);
			break;

		case "Take a trip to Reading Railroad":
			bored.moveToReadingRailroad();
			chanceDeck.discardChance(card);
			break;

		default:
			chanceDeck.discardChance(card);
		}
	}

	private void drawCommunityCard() {

		if (communityDeck.isEmptyComunityDeck()) {
			communityDeck.replenishCommunityDeck();
			drawCommunityCard();
		}
		String card = communityDeck.drawComunityCard();

		switch (card) {
		case "Advance to Go":
			bored.moveToGo();
			communityDeck.discardCommunityCard(card);
			break;

		case "Get Out of Jail Free":
			player1.keepCard(card);
			break;

		case "Go to Jail":
			bored.moveToJail();
			communityDeck.discardCommunityCard(card);
			break;

		default:
			chanceDeck.discardChance(card);
		}

	}

	public void printBored() {
		System.out.print(bored);
	}
}

