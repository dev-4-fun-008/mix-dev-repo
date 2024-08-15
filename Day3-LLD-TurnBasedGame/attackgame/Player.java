package mix.attackgame;

class Player {
    private final int[][] matrix;
    private final String name;

    public Player(int[][] matrix, String name) {
        this.matrix = matrix;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return matrix.length;
    }

    public int getCols() {
        return matrix[0].length;
    }

    public boolean attack(int row, int col) {
        if (matrix[row][col] == 1) {
            matrix[row][col] = 0; // Ship hit
            return true;
        }
        return false;
    }

    public boolean hasShipsRemaining() {
        for (int[] rows : matrix) {
            for (int cell : rows) {
                if (cell == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
