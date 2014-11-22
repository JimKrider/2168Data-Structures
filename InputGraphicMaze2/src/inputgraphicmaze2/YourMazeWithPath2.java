/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputgraphicmaze2;
import java.util.*;
import java.awt.Point;
import java.util.LinkedList;
/**
 *
 * @author Jim
 */
public class YourMazeWithPath2 {
   
    private InputGraphicMaze2 maze;
    private int R, C; 
   /* YOU'LL NEED TO ADD MORE CODE HERE!!!!!!! */

    public YourMazeWithPath2() 
    {       
       // an R rows x C columns maze
       maze = new InputGraphicMaze2();
       R=maze.Rows(); C=maze.Cols();  
      /* YOU'LL NEED TO ADD MORE CODE HERE!!!!!!!*/
       // Path holds the cells of the path
       LinkedList<Point> Path = new LinkedList<Point>();
       // Create the path
       CreatePath(maze, 1, 1, R, C, Path);
       // show the path in the maze
       maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    public boolean CreatePath(InputGraphicMaze2 maze,      
      int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
          YOUR CODE FOR THE PATH GENERATION GOES HERE!!!!!!!
        
    }

    public static void main(String[] args)
    {new YourMazeWithPath2();}
}
