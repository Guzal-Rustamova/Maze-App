public class MazeSolverStack extends mazeSolver {

    private MyStack<Square> worklist;

    public MazeSolverStack(Maze maze) {
        super(maze);
        worklist = new MyStack<>();
        worklist.push(maze.getStart());
    }

    public void makeEmpty() {
        worklist = new MyStack<>();
    }

    public boolean isEmpty() {
        return worklist.isEmpty();
    }

    public void add(Square sq) {
        worklist.push(sq);
    }

    public Square next() {
        return (Square) worklist.pop();
    }

}
