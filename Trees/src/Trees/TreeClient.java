
package Trees;
import java.util.*;

/**
 *
 * @author Jimbo
 */
public class TreeClient {
 
    /**
     *
     * @param args
     */
    public static void main(String[] args)
   {    
        int i =0;
        System.out.println("Enter # of random integers to be generated");
        Scanner keyboard = new Scanner(System.in);
        int n =9;
        BinaryTree BST = new BinaryTree();
      /*  Random gen = new Random(); 
        long lapse=0, begin, end; int k=0;
      while (k<n) 
      {
          i = 5*(gen.nextInt(n)+1); 
         begin=System.currentTimeMillis();
         BST.insert(i);
         end=System.currentTimeMillis();
         lapse=lapse+(end-begin);
         k++;
      }*/
        BST.insert(5); BST.insert(7); BST.insert(3); BST.insert(9); BST.insert(2); BST.insert(4);
         BST.insert(1); BST.insert(6); BST.insert(10); BST.insert(8);
        System.out.println("The # of integers in BST is "+BST.get_howmany());
    //    System.out.println("Time in milliseconds "+lapse);
        System.out.println("Integers in The BST are "); BST.print();
        System.out.println("Number of Integers larger then 200 --> "+ BST.largerThen(200));
        BST.largerThenOmit(2);  
        System.out.println("Integers in The BST are "); BST.print();
   }
}

