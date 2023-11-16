import java.io.File;

public class App {
    public static void main(String[] args) {
        File boardTiles = new File("boardTiles.txt");
        if(boardTiles == null) {
            System.out.println("Could not find boardTiles.txt!");
            return;
        }

        Board b = new Board(boardTiles);
    }
}
