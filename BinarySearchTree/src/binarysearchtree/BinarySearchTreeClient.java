
package binarysearchtree;
import java.util.*;
import java.io.*;

/**
 *
 * @author Jimbo
 */
public class BinarySearchTreeClient {
 
   public static void main(String[] args)
   {
      System.out.println("Enter # of random integers to be generated");
      Scanner blackboard=new Scanner(System.in);
      int n=blackboard.nextInt();
      BinarySearchTree BST=new BinarySearchTree(n);
      Random gen=new Random(); long lapse=0, begin, end; int k=0;
      while (k<n) 
      {
         int i=5*(gen.nextInt(n)+1); 
         begin=System.currentTimeMillis();
         BST.insert(i);
         end=System.currentTimeMillis();
         lapse=lapse+(end-begin);
         k++;
      }
      System.out.println("The # of integers in BST is "+BST.get_howmany());
      System.out.println("Time in milliseconds "+lapse);
      System.out.println("Time in Seconds "+lapse/1000.00+"\n");
      
      
   }
}
