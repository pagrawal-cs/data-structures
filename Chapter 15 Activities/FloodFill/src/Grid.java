import java.util.Stack;

// Pair Class
class Pair {
    private int row;
    private int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

class Grid {
    private static final int SIZE = 10;
    private int[][] pixels = new int[SIZE][SIZE];

    public void floodfill(int row, int column) {
        // Push the (row, column) pair onto a stack.
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, column));
        int fillValue = 1; 

        while (!stack.isEmpty()) {
            // Pop off the (row, column) pair from the top of the stack.
            Pair current = stack.pop();
            int currentRow = current.getRow();
            int currentCol = current.getCol();

            // Fill the corresponding array location with a number 1, 2, 3, and 
            // so on (to show the order in which the square is filled)

            // Check if current position is within bounds & not filled
            if (currentRow >= 0 && currentRow < SIZE && currentCol >= 0 && currentCol < SIZE && pixels[currentRow][currentCol] == 0) {
                // Fills the current position
                pixels[currentRow][currentCol] = fillValue++;
                
                // Push the coordinates of any unfilled neighbors in the north, east, south, or west direction on the stack
                stack.push(new Pair(currentRow - 1, currentCol)); // North
                stack.push(new Pair(currentRow, currentCol + 1)); // East
                stack.push(new Pair(currentRow + 1, currentCol)); // South
                stack.push(new Pair(currentRow, currentCol - 1)); // West
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                r.append(String.format("%4d", pixels[i][j]));
            }
            r.append("\n");
        }
        return r.toString();
    }
}
