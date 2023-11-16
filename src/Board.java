public class Board {
    private Tile head;
    private Tile tail;
    private int n;

    public Board() {
        n = 0;
            add("Go");
            add("Mediterranean Avenue");
            add("Community Chest");
            add("Baltic Avenue");
            add("Income Tax");
            add("Reading Railroad");
            add("Oriental Avenue");
            add("Chance");
            add("Vermont Avenue");
            add("Connecticut Avenue");
            add("Jail");
            add("St. Charles Place");
            add("Electric Company");
            add("States Avenue");
            add("Virginia Avenue");
            add("Pennsylvania Railroad");
            add("St. James Place");
            add("Community Chest");
            add("Tennessee Avenue");
            add("New York Avenue");
            add("Free parking");
            add("Kentucky Avenue");
            add("Chance");
            add("Indiana Avenue");
            add("Illinois Avenue");
            add("B. & O. Railroad");
            add("Atlantic Avenue");
            add("Ventnor Avenue");
            add("Water Works");
            add("Marvin Gardens");
            add("Go to Jail");
            add("Pacific Avenue");
            add("North Carolina Avenue");
            add("Community Chest");
            add("Pennsylvania Avenue");
            add("Short Line");
            add("Chance");
            add("Park Place");
            add("Luxury Tax");
            add("Boardwalk");

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
