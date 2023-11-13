import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Maze {
    private Square[][] maze;
    private Square start;
    private Square end;

    private int numRows, numCols;

    /*
     * @param String fname
     */
    public boolean loadMaze(String fname) {
        try (Scanner in = new Scanner(new File(fname))) {
            this.numRows = Integer.parseInt(in.next());
            this.numCols = Integer.parseInt(in.next());

            this.maze = new Square[numRows][numCols];

            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    maze[row][col] = new Square(row, col, Integer.parseInt(in.next()));
                    if (maze[row][col].getType() == 2)
                        start = maze[row][col];
                    if (maze[row][col].getType() == 3)
                        end = maze[row][col];

                }
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Cant open file");
        }
        return false;
    }

    public ArrayList<Square> getNeighbors(Square sq) {
        ArrayList<Square> neighbors = new ArrayList<>();

        int row = sq.getRow();
        int col = sq.getCol();

        if (row != 0) // North
            neighbors.add(maze[row - 1][col]);
        if (col != this.numCols - 1) // East
            neighbors.add(maze[row][col + 1]);
        if (row != this.numRows - 1) // South
            neighbors.add(maze[row + 1][col]);
        if (col != 0) // West
            neighbors.add(maze[row][col - 1]);

        return neighbors;
    }

    public Square getStart() {
        return start;
    }

    public Square getFinish() {
        return end;
    }

    public void reset() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                maze[row][col].setPrev(null);
                if (maze[row][col].getType() == 4 || maze[row][col].getType() == 5 || maze[row][col].getType() == 6)
                    maze[row][col].reset();
            }
        }
    }

    public String toString() {
        String str = "";

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                str += maze[row][col] + " ";
            }
            str += "\n";
        }

        return str;
    }
}
