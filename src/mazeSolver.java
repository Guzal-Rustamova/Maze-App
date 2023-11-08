import java.util.ArrayList;
import java.util.Stack;

public abstract class mazeSolver {

    protected Maze maze;
    protected myQueue<Square> worklist;

    /*
     * Create a non-abstract constructor that takes a Maze as a parameter and stores
     * it in a variable that
     * childrens
     */
    public mazeSolver(Maze maze) {
        this.maze = maze;
        worklist = new myQueue<>();
        worklist.enqueue(maze.getStart());
    }

    /*
     * create an empty worklist
     */
    public abstract void makeEmpty();

    /*
     * return true if the worklist is empty
     */
    public abstract boolean isEmpty();

    /*
     * add the given Square to the worklist
     * when adding square, set square.prev
     */
    public abstract void add(Square sq);

    /*
     * return the "next" item from the worklist
     */
    public abstract Square next();

    /*
     * A non-abstract method that the application program
     * can use to see if this algorithm has solved this maze.
     * That is, has it determined the path to the exit or if
     * there is no path.
     */

    public boolean isSolved() {
        return (maze.getFinish().getPrev() != null || this.isEmpty());
    }

    /*
     * Returns either a string of the solution path as a list of coordinates [i,j]
     * from the start to the exit or a message indicating no such path exists
     * If the maze isn't solved, you should probably return a message indicating
     * such.
     */
    public String getPath() {
        String path = "";
        if (!this.isSolved())
            return ("There is no solution to the Maze.");

        if (maze.getFinish().getPrev() == null && this.isEmpty())
            return ("There is no possible path.");

        Stack<String> track = new Stack<>();
        Square foo = maze.getFinish();
        while (!foo.equals(maze.getStart())) {
            if (foo.getType() != 3) {
                foo.setType(6);
            }
            track.push(", [" + foo.getRow() + ", " + foo.getCol() + "]");
            foo = foo.getPrev();
        }

        path += "[" + foo.getRow() + ", " + foo.getCol() + "]";
        while (!track.isEmpty()) {
            path += track.pop();
        }

        return path;
    }

    /*
     * perform one iteration of the algorithm above (i.e., steps 1 through 5) and
     * return
     * the Square that was just explored (and null if no such Square exists).
     */

    public Square step() {
        Square foo;
        // if worklist empty, terminate program
        if (this.isEmpty()) {
            return null;
        }
        // grab next loc
        foo = this.next();
        // check if that location is the finish, if it is, terminate and the thing is
        // solved
        //
        // else, explore adjacent squares and add them to the queue / stack
        ArrayList neighbors = maze.getNeighbors(foo);
        for (Object x : neighbors) {
            if (((Square) x).getType() == 3) {
                ((Square) x).setPrev(foo);
            }
            if (((Square) x).getType() == 0) {
                ((Square) x).setPrev(foo);
                ((Square) x).setType(4);
                this.add((Square) x);
            }
        }
        foo.setType(5);
        return foo;
    }

    public void solve() {
        while (!this.isSolved()) {
            step();
        }
    }

}