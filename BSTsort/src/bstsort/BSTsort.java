/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstsort;

import java.util.Random;

/**
 *
 * @author Jim
 */
public class BSTsort {
    public int howmany;
    private btNode c;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        /* This is for the ARRAY TO BINARY TREE */
        BSTsort arrayTest   = new BSTsort();
        Random gen  = new Random();
        int[] a     = new int[10];int i; 
        for (i=0; i<a.length; i++){ a[i]=gen.nextInt(20)+1; }/*<--Random Num Gen Not SO random */
        quicksort(a,0,a.length-1);/*<-------------Had to sort it, was bothering me*/
        System.out.print("Sorted Array --> ");
        for(i=0;i<a.length;i++){System.out.print(a[i]+" ");}
        System.out.println();
        arrayTest.arrayBTSort(a, 0, a.length-1);
        System.out.println("The Array In a Binary Tree --> ");
        arrayTest.print();
        /*End of The ARRAY TO BINARY TREE TEST*/
        /*Binary Tree to Array Then Back to Tree Sorted*/
        System.out.println("\nThe Binary Tree ---> ");
        BSTsort btNodeTest  = new BSTsort();
        Random BSTgen = new Random(); 
        int[] numb = {5,10,9,3,2,7,8,1,4};
        for (i=0; i<numb.length; i++){btNodeTest.insert(numb[i]);}
        btNodeTest.print();
        int[] btNodeArray = new int[btNodeTest.howmany];
        
        btNodeTest.btsToArray(btNodeArray,0);
        for(i=0;i<btNodeArray.length;i++){System.out.print(btNodeArray[i]+" ");}
        System.out.println();
        
    }
    public BSTsort(){
      c = null;
      howmany = 0;
    } 
    public BSTsort(int i){
      c = null;
      howmany = 0;
    } 
    public int get_howmany() {return howmany;}
    public void print()
    {
      printtree(c);
      if(c == null){System.out.println(c);}
    }
    private static void printtree(btNode t)
    {    
      if(t != null)
      {  
        printtree(t.left);
        System.out.println(t.info);
        if(t.right != null)
            System.out.println("Right " + t.right.info);
        else
            System.out.println("Right is null" );
        if(t.left != null)
            System.out.println("Left " + t.left.info);
        else
            System.out.println("Left is null" );
        printtree(t.right);
      } 
    }   
    public void arrayBTSort(int[] a,int start, int end)
    {
        
        c = sortedArrayToBST(a,start,end);//sets this.c to the sorted tree
      
    }
    public void btSort(int start, int end){
        int[] sort = new int[howmany];
        toarray(this.c,sort,howmany);
        
        c = sortedArrayToBST(sort,start,end);
    }
    private btNode sortedArrayToBST(int[] a, int start, int end)
    {
        if(start > end)
            return null;
        int mid       = (start + end)/2;
        btNode root   = new btNode(a[mid], null, null);howmany++;
        root.left     = sortedArrayToBST(a,start,mid-1);
        root.right    = sortedArrayToBST(a,mid+1,end);
        return root;
    }
    public void btsToArray(int[] a, int i){
        toarray(this.c,a,i);
    }
    private static void toarray(btNode t, int[] a, int i)
    {   
        if(t==null){return;}
        toarray(t.left, a, i*2);
        a[i] = t.info; 
        toarray(t.right, a, i+1);
        
        
    }//End of toarray method
    
    
    public static void quicksort(int a[], int l, int h)
    {
        int p;
        if((h - l) > 0){
            p = partition(a,l,h);
            quicksort(a,   l, p-1);
            quicksort(a, p+1, h);
        }
    }
    public static int partition( int data[], int l, int h)
    {
        int upper;
        int lower;
        int firsthigh;
        upper = l; lower = h; firsthigh = data[l];
        while(upper != lower){
            while((upper < lower)&&(firsthigh >= data[lower]))
                   lower--;
                if(upper != lower){
                   data[upper] = data[lower];
                }             
            while((upper < lower)&&(firsthigh <= data[upper]))
                   upper++;
                if(upper != lower){
                   data[lower] = data[upper];
                }
          
        }       
        data[upper] = firsthigh;
        return(upper);
    }
    public void insert(int i)
    {
      btNode pred = null, p = c;
      while ((p != null)&&(p.info != i))
      {
            pred = p;
            if (p.info > i) p = p.left; //If i is less then Current node go LEFT
            else p = p.right;           //Else go right
      }
      if (p == null)                    //If the node is null
      {
         howmany++; p = new btNode(i, null, null);//create a new one
        if (pred != null)
        {
            if (pred.info > i) pred.left = p;
            else pred.right = p;
        }
        else c = p;
      }
    }   
    private static class btNode
    {
       int info; btNode left; btNode right;

       private btNode(int s, btNode lt, btNode rt)
       {
        info = s; left = lt;   right = rt;  
        }

       private btNode()
       {
        info = 0; left = null; right = null;
        }
    }//End of Class btNode
    
}
