import java.util.Scanner;

import java.io.File;

public class Board {
    private Tile head;
    private Tile tail;
    private int n;

    public Board(File board) {
        n = 0;

        try (Scanner scan = new Scanner(board)) {
            while(scan.hasNextLine()) add(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Could not open boardTiles.txt!");
        }


        move(5);
        System.out.println("head: " + head.action);

        move(10);
        System.out.println("head: " + head.action);

        move(6);
        System.out.println("head: " + head.action);
    }

    // CIRCULAR LINKED QUEUE STRUCTURE
    private class Tile {
        public String action;
        public int timesLanded;
        public Tile next;
        public Tile prev;

        public Tile(String action) { this.action = action; }

        public void landed() {
            timesLanded++;
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

    private void add(String action) {
        if(n == 0) {
            head = new Tile(action);
            n++;
            return;
        } else if(n == 1) {
            tail = new Tile(action);
            head.next = tail;
            tail.prev = head;
            n++;

            return;
        }

        tail.next = new Tile(action);
        tail.next.prev = tail;
        tail = tail.next;

        tail.next = head;
        n++;
    }
}
