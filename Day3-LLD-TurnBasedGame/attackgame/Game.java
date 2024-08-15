package mix.attackgame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Game {
    private final Player player1;
    private final Player player2;
    private final Semaphore semaphore;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.semaphore = new Semaphore(1); // Controls turn-taking
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> playTurn(player1, player2));
        executor.submit(() -> playTurn(player2, player1));

        executor.shutdown();
    }

    private void playTurn(Player attacker, Player defender) {
        try {
            while (defender.hasShipsRemaining()) {
                semaphore.acquire(); // Ensure only one player plays at a time

                System.out.println(attacker.getName() + " is attacking...");

                int row = (int) (Math.random() * defender.getRows());
                int col = (int) (Math.random() * defender.getCols());

                if (defender.attack(row, col)) {
                    System.out.println(attacker.getName() + " hit a ship at (" + row + ", " + col + ")!");
                } else {
                    System.out.println(attacker.getName() + " missed at (" + row + ", " + col + ").");
                    semaphore.release(); // End the attacker's turn
                    break;
                }
            }

            System.out.println(defender.getName() + " has no ships remaining. " + attacker.getName() + " wins!");
            semaphore.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
