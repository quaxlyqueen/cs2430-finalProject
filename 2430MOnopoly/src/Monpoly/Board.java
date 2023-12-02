import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

import java.io.File;

public class Board {
    private Tile head;
    private Tile tail;
    private Tile jail;
    private int n;
    private Card card;


    public Board(File board, int turns, ArrayList<Player> players) {
        n = 0;
        card = new Card();

        try (Scanner scan = new Scanner(board)) {
            while(scan.hasNextLine()) {
                add(scan.nextLine());
            }

        } catch (Exception e) {
            System.out.println("Could not open boardTiles.txt!");
        }

        int currentTurn = 0;

        while(currentTurn < turns) {
            move(players.get(0).roll());
            currentTurn++;
        }
    }

    public void printBoard() {
        Tile current = head;

        while(current != null) {
            System.out.println(current.tileName + ", " + current.timesLanded);
            current = current.next;

            if(current.tileName.equals(head.tileName)) break;
        }
    }

    private void move(int spaces) {
        int counter = 0;

        Tile current = head;
        while(counter < spaces) {
            current = current.next;
            counter++;
        }

        head = current;
        tail = current.prev;

        head.landed();
    }

    private void move(int spaces, Player player) {
        int counter = 0;

        Tile current = head;
        while (counter < spaces) {
            current = current.next;
            counter++;
        }

        head = current;
        tail = current.prev;

        head.landed();

        // Handle Chance and Community Chest cards
        handleCard(player);
    }

    private void handleCard(Player player) {
        Tile current = head;
        String tileName = current.tileName;

        // Check if the current tile is associated with a card (e.g., Chance or Community Chest)
        if (tileName.equals("Chance")) {
            Card drawnCard = card.drawChanceCard();
            player.drawChanceCard(drawnCard);
            card.returnCardToDeck(drawnCard);
        } else if (tileName.equals("Community Chest")) {
            Card drawnCard = card.drawCommunityChestCard();
            player.drawCommunityChestCard(drawnCard);
            card.returnCardToDeck(drawnCard);
        }
    }

    private void add(String tileName) {
        if(n == 0) {
            head = new Tile(tileName);
            n++;
            return;

        } else if(n == 1) {
            tail = new Tile(tileName);
            head.next = tail;
            tail.prev = head;
            n++;

            return;
        }

        tail.next = new Tile(tileName);
        tail.next.prev = tail;
        tail = tail.next;

        tail.next = head;
        n++;
    }
}
