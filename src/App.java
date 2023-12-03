import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        File boardTiles = new File("boardTiles.txt");
        if(boardTiles == null) {
            System.out.println("Could not find boardTiles.txt!");
            return;
        }

        ArrayList<Player> players = new ArrayList<>();
            players.add(new Player());

        try {
            FileWriter fw = new FileWriter("1000-results.txt");
            fw.write("1000 turns\n");
            for(int i = 1; i <= 10; i++) {
                fw.write("\n\nStrategy A - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 1000, true, players).printBoard());

                fw.write("\n\nStrategy B - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 1000, false, players).printBoard());
            }
            fw.close();

            fw = new FileWriter("10000-results.txt");
            fw.write("10000 turns\n");
            for(int i = 1; i <= 10; i++) {
                fw.write("\n\nStrategy A - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 10000, true, players).printBoard());

                fw.write("\n\nStrategy B - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 10000, false, players).printBoard());
            }
            fw.close();

            fw = new FileWriter("100000-results.txt");
            fw.write("100000 turns\n");
            for(int i = 1; i <= 10; i++) {
                fw.write("\n\nStrategy A - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 100000, true, players).printBoard());

                fw.write("\n\nStrategy B - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 100000, false, players).printBoard());
            }
            fw.close();

            fw = new FileWriter("1000000-results.txt");
            fw.write("1000000 turns\n");
            for(int i = 1; i <= 10; i++) {
                fw.write("\n\nStrategy A - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 1000000, true, players).printBoard());

                fw.write("\n\nStrategy B - Simulation " + i + "\n");
                    fw.write(new Board(boardTiles, 1000000, false, players).printBoard());
            }
            fw.close();

           System.out.println("Successfully wrote to the files.");

       } catch (IOException e) {
           System.out.println("An error occurred writing to the files.");
           e.printStackTrace();
       }
    }
}
