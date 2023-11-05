import java.util.ArrayList;

public class mazeSolverQueue extends mazeSolver {

    public mazeSolverQueue(Maze maze) {
        super(maze);
        worklist = new myQueue<Square>();
    }

    public void makeEmpty() {
        this.worklist.clear();
    }

    public boolean isEmpty() {
        return worklist.isEmpty();
    }

    public void add(Square sq) {
        worklist.enqueue(sq);
    }

    public Square next() {
        return (Square) worklist.dequeue();
    }

}
