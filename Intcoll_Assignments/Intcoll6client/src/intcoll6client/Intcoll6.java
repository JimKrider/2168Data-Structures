/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll6client;
import java.io.*;
/**
 *
 * @author Jim
 * 
 */
public class Intcoll6 {
    private int howmany;
    private btNode c;
    public Intcoll6()
    {
        c = null;
        howmany = 0;
    }

    public Intcoll6(int i)
    {
        c = null;
        howmany = 0;
    }
    
    private static btNode copytree(btNode t)
    {
        btNode root=null;
        if (t!=null)
        {
            root=new btNode();
            root.info=t.info; 
            root.left=copytree(t.left);
            root.right=copytree(t.right);
        }
        return root;
    }

   public void copy(Intcoll6 obj)
   {
      if (this!=obj)
      {
          howmany=obj.howmany;
          c=copytree(obj.c);  
      }
   }

   public void insert(int i)
   {
      btNode pred=null, p=c;

      while ((p!=null)&&(p.info!=i))
      {
		  pred=p;
		  if (p.info>i) p=p.left;
		  else p=p.right;
      }
      if (p==null)
      {
         howmany++; p=new btNode(i, null, null);
         if (pred!=null)
         {
			 if (pred.info>i) pred.left=p;
			 else pred.right=p;
		 }
		 else c=p;
      }
   }

   public void omit(int i)
   {
      btNode p =c, predp = null;
    //  System.out.println(p.info);
    //  System.out.println(p.left.info);
      while ((p!=null)&&(p.info!=i))
      {
		  predp=p;
		  if (p.info>i) {p=p.left; System.out.println("L");}
                  else{ p=p.right;System.out.println("R");}
                  
      }
       
        if((p.left == null)&&(p.right==null)){
            if(predp == null){
                c  = null;
               
            }else if(predp.info>p.info){
               predp.left = null;
           }else if(predp.info<p.info){
               predp.right=null;
           }
       }else if((p.left == null)&&(p.right != null)){
           if(predp== null){
               c=p.right;
           }else if(predp.info>p.info){
               predp.left = p.right;
            }else{
               predp.right= p.right;
           }
       }else if((p.left != null)&&(p.right == null)){
           if(predp==null){
               c = p.left;
           }else if(predp.info>p.info){
               predp.left = p.left;
            }else{
               predp.right= p.left;
           }
       }else if((p.left != null)&&(p.right != null)){   // Use the minimum tree traversal 
           if(predp==null){
            btNode max = p.left,maxpred=null;
            
            while(max.right!=null){
                maxpred=max;
                max = max.right;
            }
           
           c.info=max.info;
           maxpred.right=max.left;
           c.right=p.right;
           c.left=p.left;
           
            }else if(predp.info>p.info){
                btNode min = p;
                
               while(min.left!=null){
                   min= min.left;
               }
               predp.left = min;
               min.right = p.right;
            }else{
               btNode min = p;
               while(min.left!=null){
                   min = min.left;
                }
              predp.right=min; 
              min.right=p.right;
               
           }
       }
          
          
              
      
   }

   public boolean belongs(int i)
   {
      btNode p=c;
      while ((p!=null)&&(p.info!=i)) 
      {
         if (p.info>i) p=p.left;
         else p=p.right;
      }
      return (p!=null); 
   }

   public int get_howmany() {return howmany;}

   public void print(String outname)
   {
      try
      {
	 PrintWriter outs =new PrintWriter(new FileOutputStream(outname));
         outs.println("The number of integers is "+howmany);
         outs.println();
         printtree(c, outs);
         outs.close();
      }catch (IOException ex)
      {
      }
   }

   public void print()
   {
      printtree(c);
      if(c == null){
         System.out.println(c);
      }
   }

   public boolean equals(Intcoll6 obj)
   {
      int j = 0; boolean result  = (howmany==obj.howmany);
      if (result)
      { 
         int[] a=new int[howmany]; 
         int[] b=new int[howmany];
         toarray(c, a, 0); toarray(obj.c, b, 0);

         j=0;
         while ((result) && (j<howmany))
         {
            result=(a[j]==b[j]); j++;
         }
      }
      return result;
   }

   private static void printtree(btNode t, PrintWriter outs)
   {   
	   if (t!=null)
	   {
		   printtree(t.left, outs);
		   outs.println(t.info );
		   printtree(t.right, outs);
	   }
   }

   private static void printtree(btNode t)
   {    
      if(t!=null)
      {   //System.out.print(" Blah " + t.info);
          printtree(t.left);
          System.out.println(t.info);
         if(t.right!=null)
              System.out.println("Right " + t.right.info);
          else
              System.out.println("Right is null" );
          if(t.left!=null)
              System.out.println("Left " + t.left.info);
          else
              System.out.println("Left is null" );
           printtree(t.right);
      } 
   }

   private static int toarray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 

   private static class btNode
   {
       int info; btNode left; btNode right;

       private btNode(int s, btNode lt, btNode rt)
       {
          info=s; left=lt; right=rt;  
       }

       private btNode()
       {
          info=0; left=null; right=null;
       }
   }
}
