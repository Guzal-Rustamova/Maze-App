import java.util.ArrayList;

public abstract class mazeSolver {

    protected Maze maze;
    private ArrayList<Square> worklist;
    


    /*
     * Create a non-abstract constructor that takes a Maze as a parameter and stores it in a variable that
     * childrens 
     */
    public mazeSolver(Maze maze)
    {
        this.maze = maze;
        this.worklist = new ArrayList<>();
        //worklist.enqueue(maze.getStart());
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

    public boolean isSolved()
    {
        return (worklist.contains(maze.getFinish()) || worklist.isEmpty());
    }

    /*
     * Returns either a string of the solution path as a list of coordinates [i,j] 
     * from the start to the exit or a message indicating no such path exists
        If the maze isn't solved, you should probably return a message indicating such.
     */
    public String getPath()
    {
        String path = "[";
        if(!isSolved()) return ("There is no solution to the Maze.");
        
        if (worklist.isEmpty()) return ("There is no possible path.");
        
        for (Square x : worklist) {
            path += " "+x.getRow()+","+x.getCol()+"]";
        }
        return path;

    }

    /*
     * perform one iteration of the algorithm above (i.e., steps 1 through 5) and return
     *  the Square that was just explored (and null if no such Square exists). 
     */
    public Square step()
    {
        Square foo;
        // if worklist empty, terminate program
        if (worklist.isEmpty())
        {
            return null; 
        }
        // grab next location; aka next square in the queue / stack
        foo = this.next();
        if (foo.getRow() == maze.getFinish().getRow() && foo.getCol() == maze.getFinish().getCol()) return null;
        // check if that location is the finish, if it is, terminate and the thing is solved
        // else, explore adjacent squares and add them to the queue / stack
        else {
            this.add(foo); return foo;
        }

    }
    public void solve()
    {
        while (!worklist.isEmpty())
        {
            step(); 
        }
    }


}
