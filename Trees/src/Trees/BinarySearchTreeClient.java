
package Trees;
import java.util.*;

/**
 *
 * @author Jimbo
 */
public class BinarySearchTreeClient {
 
    /**
     *
     * @param args
     */
    public static void main(String[] args)
   {    
      int i =0;
      System.out.println("Enter # of random integers to be generated");
      Scanner keyboard = new Scanner(System.in);
      int n = keyboard.nextInt();
      BinarySearchTree BST = new BinarySearchTree();
     Random gen = new Random(); 
     long lapse=0, begin, end; int k=0;
      while (k<n) 
      {
          i = 5*(gen.nextInt(n)+1); 
         begin=System.currentTimeMillis();
         BST.insert(i);
         end=System.currentTimeMillis();
         lapse=lapse+(end-begin);
         k++;
      }
     

      System.out.println("The # of integers in BST is "+BST.get_howmany());
      System.out.println("Time in milliseconds "+lapse);
      System.out.println("Integers in The BST are "); BST.print();
      System.out.println("Number of Integers larger then 200 --> "+ BST.largerThen(200));
       BST.largerThenOmit(25);  
     /* int size = BST.get_howmany();
        int[] btNodeArray = new int[size];
        BST.btsToArray(btNodeArray,0);
        for(i=0;i<btNodeArray.length;i++){System.out.print(btNodeArray[i]+" ");}
        System.out.println("\n");
        BST.heapsort(btNodeArray);
        for(i=0;i<btNodeArray.length;i++){System.out.print(btNodeArray[i]+" ");}*/
      //System.out.println("Integers in The BST are "); BST.print();
       
        System.out.println("Integers in The BST are "); BST.print();
   }
}

