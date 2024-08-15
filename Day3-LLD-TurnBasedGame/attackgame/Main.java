package mix.attackgame;

public class Main {

    public static void main(String[] args) {

        int[][] matrix1 = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 1, 0}
        };

        int[][] matrix2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        Player player1 = new Player(matrix1, "Player 1");
        Player player2 = new Player(matrix2, "Player 2");

        Game game = new Game(player1, player2);
        game.start();

    }
}
