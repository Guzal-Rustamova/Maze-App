import java.util.Queue;

public abstract class mazeSolver implements Maze {

    protected Maze maze;
    private myQueue worklist = new myQueue();
    worklist.add(maze.getStart());


    /*
     * Create a non-abstract constructor that takes a Maze as a parameter and stores it in a variable that
     * childrens 
     */
    public mazeSolver(Maze maze)
    {
        this.maze = maze;
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
        if (worklist.isEmpty())
        {
            return false; 
        }
    }

    /*
     * Returns either a string of the solution path as a list of coordinates [i,j] 
     * from the start to the exit or a message indicating no such path exists
        If the maze isn't solved, you should probably return a message indicating such.
     */
    public String getPath()
    {
        String path = "["
        if(!isSolved())
        {
            System.out.println("There is no solution to the Maze.");
        } else 
        {
            path+=" "+worklist.getRow()+","+worklist.getCol()+"]";
        }

    }

    /*
     * perform one iteration of the algorithm above (i.e., steps 1 through 5) and return
     *  the Square that was just explored (and null if no such Square exists). 
     */
    public step()
    {

    }
    public void solve()
    {
        while (!worklist.isEmpty())
        {
            step(); 
        }
    }


}
