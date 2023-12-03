import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.lang.StringBuilder;

import java.io.File;

public class Board {
    private ArrayList<Player> players;

    private Tile head;
    private Tile tail;
    private Tile jail;

    private Deck chance;
    private Deck communityChest;

    private int n;
    private boolean inJail;
    private int turnsInJail;

    private int turns;

    public Board(File board, int turns, boolean strategy, ArrayList<Player> players) {
        this.turns = turns;
        this.players = players;
        chance = new Deck("chance.txt");
        communityChest = new Deck("community.txt");
        n = 0;

        try (Scanner scan = new Scanner(board)) {
            while(scan.hasNextLine()) {
                add(scan.nextLine());
            }

        } catch (Exception e) {
            System.out.println("Could not open boardTiles.txt!");
        }

        int currentTurn = 0;

        while(currentTurn < turns) {
            if(players.get(0).getDoubleDiceRoll() == 3) {
                players.get(0).resetDoubleDiceRoll();
                moveTo("Jail");
                inJail = true;
            } else if(inJail) {
                if(strategy) strategyA();
                else strategyB();
            } else {
                move(players.get(0).roll());
            }

            if(head.tilename.equals("Chance")) {
                String action = chance.draw();
                if(action.contains("Advance")) {
                    if(action.contains("Go")) {
                        moveTo("Go");
                    } else if(action.contains("Illinois")) {
                        moveTo("Illinois");
                    } else if(action.contains("St. Charles")) {
                        moveTo("St. Charles");
                    } else if(action.contains("Railroad")) {
                        moveTo("Railroad");
                    } else if(action.contains("Boardwalk")) {
                        moveTo("Boardwalk");
                    } else if(action.contains("Reading")) {
                        moveTo("Reading");
                    } else if(action.contains("Jail")) {
                        moveTo("Jail");
                    } else if(action.contains("Back")) {
                        System.out.println("moving back");
                        move(-3);
                    } /*else if(action.contains("Utility")) {
                        moveTo("Utility");
                    }*/
                } else if(action.contains("free")) {
                    players.get(0).addGetOutOfJailCard();
                }
            } else if(head.tilename.equals("Community Chest")) {
                String action = communityChest.draw();
                //System.out.println(action);
                // perform action
            } else if(head.tilename.equals("Go To Jail")) {
                moveTo("Jail");
            } else if(head.tilename.equals("Jail")) {
                inJail = true;
            }

            currentTurn++;
        }
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" | %-25s | %-15s | %-15s |", "Tile", "Times Landed", "Percentage"));
        sb.append("\n |---------------------------+-----------------+-----------------|");

        Tile current = jail;

        while(current != null) {
            sb.append(String.format("\n | %-25s | %-15d | %-15f |", current.tilename, current.timesLanded, (double) current.timesLanded / (double) turns * 100));
            current = current.next;

            if(current.tilename.equals(jail.tilename)) {
                sb.append("\n -----------------------------------------------------------------");
                break;
            } else {
                sb.append("\n |---------------------------+-----------------+-----------------|");
            }
        }

        return sb.toString();
    }

    private void strategyA() {
        if(players.get(0).hasGetOutOfJailCard()) {
            players.get(0).useGetOutOfJailCard();
            inJail = false;
            turnsInJail = 0;
            move(players.get(0).roll());
        } else if(turnsInJail == 1) {
            move(players.get(0).roll());
            turnsInJail = 0;
            inJail = false;
        } else {
            turnsInJail++;
        }
    }

    private void strategyB() {
        if(players.get(0).hasGetOutOfJailCard()) {
            inJail = false;
            turnsInJail = 0;
            players.get(0).useGetOutOfJailCard();
            move(players.get(0).roll());
        } else if(turnsInJail == 3) {
            inJail = false;
            turnsInJail = 0;
            move(players.get(0).roll());
        } else {
            int roll = players.get(0).roll();
            if(players.get(0).getDoubleDiceRoll() == 1) {
                inJail = false;
                turnsInJail = 0;
                move(roll);
            } else {
                turnsInJail++;
            }
        }
    }

    private void move(int spaces) {
        int counter = 0;

        Tile current = head;

        if(spaces < 0) {
            while(counter > spaces) {
                current = current.prev;
                counter--;
            }
        } else {

            while(counter < spaces) {
                current = current.next;
                counter++;
            }
        }

        head = current;
        tail = current.prev;

        head.landed();
    }

    private void moveTo(String tilename) {
        if(tilename.equals("Jail")) {
            head = jail;
            tail = jail.prev;

            return;
        }

        if(tilename.equals("Utility")) {
            Tile current = head;

            while(!current.tilename.contains("Water") || !current.tilename.contains("Electric")) {
                current = current.next;
            }

            head = current;
            tail = current.prev;

            head.landed();
            return;
        }

        Tile current = head;

        while(!current.tilename.contains(tilename)) {
            current = current.next;
        }

        head = current;
        tail = current.prev;

        head.landed();
    }

    private void add(String tilename) {
        if(n == 0) {
            head = new Tile(tilename);
            n++;
            return;

        } else if(n == 1) {
            tail = new Tile(tilename);
            head.next = tail;
            tail.prev = head;
            n++;

            return;
        }

        tail.next = new Tile(tilename);
        tail.next.prev = tail;
        tail = tail.next;

        if(tail.prev.tilename.equals("Jail")) jail = tail.prev;

        tail.next = head;
        n++;
    }
}
