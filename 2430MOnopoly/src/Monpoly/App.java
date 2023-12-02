import java.io.File;
import java.util.ArrayList;

import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // TODO: Add cross platform support
        File boardTiles = new File("boardTiles.txt");
        if (!boardTiles.exists()) {
            System.out.println("Could not find boardTiles.txt!");
            return;
        }
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player());

        for (int i = 0; i < 10; i++) {
            System.out.println("Simulation with Strategy A:");
            runSimulation(boardTiles, 1000, players, "A");
            runSimulation(boardTiles, 10000, players, "A");
            runSimulation(boardTiles, 100000, players, "A");
            runSimulation(boardTiles, 1000000, players, "A");

            System.out.println("\nSimulation with Strategy B:");
            runSimulation(boardTiles, 1000, players, "B");
            runSimulation(boardTiles, 10000, players, "B");
            runSimulation(boardTiles, 100000, players, "B");
            runSimulation(boardTiles, 1000000, players, "B");
        }
    }

    private static void runSimulation(File boardTiles, int turns, ArrayList<Player> players, String strategy) {
        Board board = new Board(boardTiles, turns, players);

        for (Player player : players) {
            for (int turn = 0; turn < turns; turn++) {
                player.roll();

                // Simulate the game based on the chosen strategy
                if (strategy.equals("A")) {
                    // TODO: Implement Strategy A
                    // For example: board.move(rolledValue); or board.moveWithStrategyA(player);
                } else if (strategy.equals("B")) {
                    // TODO: Implement Strategy B
                    // For example: board.move(rolledValue); or board.moveWithStrategyB(player);
                }
            }

            // Print the information after each simulation
            System.out.println("\nAfter " + turns + " turns with Strategy " + strategy + ": ");
            board.printBoard();
        }
    }
}
