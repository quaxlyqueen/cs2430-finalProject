import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        File boardTiles = new File("boardTiles.txt");
        if(boardTiles == null) {
            System.out.println("Could not find boardTiles.txt!");
            return;
        }
        ArrayList<Player> players = new ArrayList<>();
            players.add(new Player());

        Board b1000 = new Board(boardTiles, 1000, players);
        Board b10000 = new Board(boardTiles, 10000, players);
        Board b100000 = new Board(boardTiles, 100000, players);
        Board b1000000 = new Board(boardTiles, 1000000, players);

        System.out.println("\n\n1000 turns: ");
        b1000.printBoard();

        System.out.println("\n\n10000 turns: ");
        b10000.printBoard();

        System.out.println("\n\n100000 turns: ");
        b100000.printBoard();

        System.out.println("\n\n1000000 turns: ");
        b1000000.printBoard();
    }
}
