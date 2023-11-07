public class MazeSolverStack extends mazeSolver{

    private MyStack worklist; 


    public MazeSolverStack()
    {
        super(maze); 
        worklist = new MyStack<>(); 
    }

    public void makeEmpty()
    {
        worklist = new MyStack<>(); 
    }

    public boolean isEmpty()
    {
        return worklist.isEmpty(); 
    }

    public void add(Square sq)
    {
        worklist.push(sq);
    }

    public Square next()
    {
        return (Square) worklist.pop(); 
    }

}
