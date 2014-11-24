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
    private int[][] V;
    
    public YourMazeWithPath2() 
    {       
        // an R rows x C columns maze
        maze = new InputGraphicMaze2();
        R = maze.Rows();
        C = maze.Cols();  
        V = new int[R+1][C+1];/*<-----For BFS */
        for (int i=1; i<=R; i++){/*<----- For BFS */
            for (int j=1; j<=C; j++){/*<----- For BFS */
                 V[i][j]=0;/*<----- For BFS */
            }
        }
        /* YOU'LL NEED TO ADD MORE CODE HERE!!!!!!!*/
        // Path holds the cells of the path
        LinkedList<Point> Path = new LinkedList<>();
        // Create the path
        createPathBFS(maze, 1, 1, R, C, Path);/*<----- For BFS */
        // show the path in the maze
        maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
   /* public boolean CreatePathDFS(InputGraphicMaze2 maze,      
      int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
         /* YOUR CODE FOR THE PATH GENERATION GOES HERE!!!!!!!
        
    }*/

    public boolean createPathBFS(InputGraphicMaze2 maze,      
      int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
        int r = srow,    c = scol, 
        R = maze.Rows(), C = maze.Cols(); 
        int size  = R*C+1;/* Sets the size to the size of the graph, or Matrix*/
        Point[] P = new Point[size];/* this is used to store the Nodes */
        boolean done  = false; 
        V[srow][scol] = 1; 
        int scell = (srow-1) * C + scol;
        int cell;
        P[scell]  = new Point(0, 0); /*From Node class in InputGraphic */
        Point u   = new Point(r, c); /*From Node class in InputGraphic */
        LinkedList<Point> Q = new LinkedList<>();
        Q.add(u);
        while (!done)
        {             
           u = Q.remove();
           r = (int) u.getX();
           c = (int) u.getY(); /* r and c get the X and Y coordinates */
           if ((r==erow)&&(c==ecol)) done=true; /*Checks the r and c to see if they are equal to the edge eROW or the eCOlUMN*/
           else
            {  
                if ((r>1)&&(V[r-1][c]!=1)&&(maze.can_go(r, c,'U')))/*checks to see if it can go UP*/
                {
                    V[r-1][c]    = 1;/* there is an Edge from V.r-1 to V.c */
                    P[(r-2)*C+c] = u;
                    Q.add(new Point(r-1, c));/* adds r-1 and c to Q which is the linked list, and addes that point to the visited list*/
                }
                if ((c<C)&&(V[r][c+1]!=1)&&(maze.can_go(r, c,'R')))/*checks to see if it can go RIGHT*/
                {
                    V[r][c+1]      = 1;
                    P[(r-1)*C+c+1] = u;
                    Q.add(new Point(r, c+1));/*c+1 means that it moves to the right by 1 */
                }
                if ((r<R)&&(V[r+1][c]!=1)&&(maze.can_go(r, c, 'D')))/*checks to see if it can go DOWN*/
                {
                    V[r+1][c] = 1;
                    P[r*C+c]  = u;
                    Q.add(new Point(r+1, c));/* r+1 means that it either goes down by one or the right */
                }              
                if ((c>1)&&(V[r][c-1]!=1)&&(maze.can_go(r, c, 'L')))/*checks to see if it can go LEFT*/             
                {
                    V[r][c-1]      = 1;
                    P[(r-1)*C+c-1] = u;
                    Q.add(new Point(r, c-1));
                }
            }           
        } //end of while
        while (!u.equals(P[scell])) 
        {         
           r = (int) u.getX();
           c = (int) u.getY();
           L.add(u);
           u = P[(r-1)*C+c]; 
        }
        return done;
    }
     
     
    public static void main(String[] args){
        new YourMazeWithPath2();
    }
    
}
