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
   
    
    private InputGraphicMaze2 mazeD;
    private int R, C; 
    private int[][] V;
    private boolean[][] visited; 
    
    public YourMazeWithPath2() 
    {       
       
        mazeD = new InputGraphicMaze2();
        R = mazeD.Rows();
        C = mazeD.Cols();
        V = new int[R+1][C+1];
       // visited = new boolean[R+1][C+1];
        for (int i=1; i<=R; i++){/*<----- For DFS */
            for (int j=1; j<=C; j++){/*<----- For DFS */
                V[i][j]=0;
                //visited[i][j]=false;/*<----- For DFS using boolean */
            }
        }
        // Path holds the cells of the path
        LinkedList<Point> PathD = new LinkedList<>();
        // Create the path
        CreatePathDFS(mazeD, 1, 1, R, C, PathD);
        // show the path in the maze
        mazeD.showPath(PathD);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    public boolean CreatePathDFS(InputGraphicMaze2 maze, int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
        boolean done = false; 
        int r = srow, c = scol; 
        V[r][c] = 1;
        if((r == erow)&&( c == ecol)){ done = true;}
        
         /*Finished?-EdgeChe-HaveIBeenHereBefore--CanIgoInThisDirection*/
        if ((!done)&&(r > 1)&&(V[r-1][c]!=1)&&(maze.can_go(r, c,'U'))){
            V[r-1][c] = 0;
            done = CreatePathDFS(maze,r-1,c,erow,ecol,L);
            if(done){L.add(new Point(r-1,c));}
        }
        if((!done)&&(c < C)&&(V[r][c+1]!=1)&&(maze.can_go(r, c,'R'))){  
            V[r][c+1] = 0; 
            done = CreatePathDFS(maze,r,c+1,erow,ecol,L);
            if(done){L.add(new Point(r,c+1));}
        }
        if((!done)&&(r < R)&&(V[r+1][c]!=1)&&(maze.can_go(r, c, 'D'))){
            V[r+1][c] = 0; 
            done = CreatePathDFS(maze,r+1,c,erow,ecol,L);
            if(done){L.add(new Point(r+1,c));}
        }
        if((!done)&&(c > 1)&&(V[r][c-1]!=1)&&(maze.can_go(r, c, 'L'))){
            V[r][c-1] = 0;
            done = CreatePathDFS(maze,r,c-1,erow,ecol,L);
            if(done){L.add(new Point(r,c-1));}
        }
        
        if(done){L.add(new Point(r,c));}
        return done;
    }

    public boolean createPathBFS(InputGraphicMaze2 maze, int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
        boolean done  = false; /*Done is used for Return statement*/
        /*srow and scol, are starting row and col*/
        int r = srow, c = scol; 
        int size  = R * C + 1;/* Sets the size from the Row and Column */
        Point[] P = new Point[size];/* this is used to store the Nodes */
      
        V[srow][scol] = 1; /*sets srow and scoll in V to 1 marking it */
        int scell = (srow-1) * C + scol;/* starting row * column size + starting column this equals 1, usually*/
        P[scell]  = new Point(0, 0); /*Sets P to 0 0 */
        Point u   = new Point(r, c); /*From Node class in InputGraphic */
        LinkedList<Point> Q = new LinkedList<>();
        Q.add(u); /* adds u to the Q or linked list*/
        while (!done)
        {             
           u = Q.remove();/*this removes u while it is in the loop of the level. */
           r = (int) u.getX();/*r is now u's X cord*/
           c = (int) u.getY();/*c is now u's Y cord*/
           if ((r == erow)&&(c == ecol)) done = true; /*if r and c are at the end row and Column made it to the end*/
           else
            {  
                if ((r > 1)&&(V[r-1][c] != 1)&&(maze.can_go(r, c,'U')))/*is Row is larger then 1 and the spot has not been marked, and can go up*/
                {
                    V[r-1][c]       = 1;/* there is an Edge from V.r-1 to V.c */
                    P[(r-2)* C + c] = u;/*Column + c.*/
                    Q.add(new Point(r-1, c));/* This adds the next point to the Q linked list. Which is the breadth first search it goes across the level*/
                }
                if ((c < C)&&(V[r][c+1] != 1)&&(maze.can_go(r, c,'R')))/*If c is not larger then the COLUMN max*/
                {
                    V[r][c+1]      = 1;
                    P[(r-1)*C+c+1] = u;
                    Q.add(new Point(r, c+1));/*c+1 means that it moves to the right by 1 */
                }
                if ((r < R)&&(V[r+1][c] != 1)&&(maze.can_go(r, c, 'D')))/*If r is not larger then ROW max*/
                {
                    V[r+1][c] = 1;
                    P[r*C+c]  = u;
                    Q.add(new Point(r+1, c));/* r+1 means that it either goes down by one or the right */
                }              
                if ((c > 1)&&(V[r][c-1] != 1)&&(maze.can_go(r, c, 'L')))/*If c is larger then 1*/             
                {
                    V[r][c-1]      = 1;
                    P[(r-1)*C+c-1] = u;
                    Q.add(new Point(r, c-1));
                }
            }           
        } //end of while
        while (!u.equals(P[scell])) /* this loops through u till it is 0,0 */
        {         
           r = (int) u.getX();
           c = (int) u.getY();
           L.add(u);
           u = P[(r-1) * C + c];/*starts at the the END and increments through the points at U*/ 
        }
        return done;
    }
     
     
    public static void main(String[] args){
        new YourMazeWithPath2();
    }
    
}
