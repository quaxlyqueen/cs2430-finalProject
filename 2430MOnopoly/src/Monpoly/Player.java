import java.util.Random;

public class Player {
    private int doubleDiceRoll;
    private int getOutOfJail;

    public Player() {
        doubleDiceRoll = 0;
        getOutOfJail = 0;
    }

    public void addGetOutOfJailCard() {
        getOutOfJail++;
    }

    public void useGetOutOfJailCard() {
        getOutOfJail--;
    }

    public boolean hasGetOutOfJailCard() {
        return getOutOfJail > 0;
    }

    public int roll() {
        Random r = new Random();
        int rollA = r.nextInt(7) + 1;
        int rollB = r.nextInt(7) + 1;

        if(rollA == rollB) doubleDiceRoll++;

        return rollA + rollB;
    }

    public int getDoubleDiceRoll() {
        return doubleDiceRoll;
    }
    public String drawChanceCard(Card card) {
        // TODO: Implement how to handle the drawn chance card
        return ""; // Placeholder
    }

    public String drawCommunityChestCard(Card card) {
        // TODO: Implement how to handle the drawn community chest card
        return ""; // Placeholder
    }
}
