package bstmultistringcoll;
import java.io.*;


/**
 *
 * @author Jimbo
 */
public class BSTMultiStringcoll {
   private int howmany;/*Distinct Words*/
   private int total;/*Total Amount of Words*/
   private btNode c;
  
   public BSTMultiStringcoll()
   {
      c = null;
      howmany = 0;
    }

   public BSTMultiStringcoll(int i)
   {
      c.count = i;
      howmany = 0;
    }

   private static btNode copytree(btNode t)
   {
      btNode root = null;
      if (t  != null)
      {
        root = new btNode();
        root.info = t.info; 
        root.left = copytree(t.left);
        root.right= copytree(t.right);
       }
      return root;
    }

   public void copy(BSTMultiStringcoll obj){
      if (!this.equals(obj))
      {
          howmany = obj.howmany;
          c = copytree(obj.c);  
      }
   }
  
   public  void insert(String i){ 
        btNode pred = null, p = c; 
        while ((p != null))
        {
            pred = p;
            if((p.info.equals(i))){
                p.count = p.count+1;
                total++;
                break;
        }
	if ((i.compareTo(p.info))<0) {p = p.left;}
        else{ p = p.right;}
        }
        if (p == null)
        {  
            howmany++;
            btNode h = new btNode(1, i, null, null);
            if (pred != null)
            {  
                if ((h.info.compareTo(pred.info))<0) { pred.left = h;}
                else  if ((h.info.compareTo(pred.info))>0){ pred.right = h;}
            }
            else c = h;
        }
   
   }
  
   public void omit(String i)
   {
      btNode p = c, predp = null;
    
        while ((p != null)&&(!(p.info.equals(i))))
        {
            predp = p;
            if ((i.compareTo(p.info))<0) {p = p.left; System.out.println("L");}
            else if((i.compareTo(p.info))>0){ p = p.right;System.out.println("R");}
        }
        if(p.count != 0)
        {
            p.count--;
        }
       
        if(p.count==0)
        {
            if((p.left == null)&&(p.right==null)){
                if(predp == null){
                    c  = null;
                }else if((p.info.compareTo(predp.info))<0){
                    predp.left  = null;
                }else{
                    predp.right = null;
                }
            }else if(p.right != null){
                if(predp == null){
                    c = p.right;
                }else if(p.info.compareTo(predp.info)<0){
                    predp.left  = p.right;
                }else{
                    predp.right = p.right;
                }
            }else if(p.left != null){
                if(predp == null){
                    c = p.left;
                }else if(p.info.compareTo(predp.info)<0){
                    predp.left  = p.left;
                }else{
                    predp.right = p.left;
                }
            }else if((p.left != null)&&(p.right != null)){   // Use the minimum tree traversal 
                if(predp==null){
                    btNode max = p.left,maxpred=null;
                    while(max.right!=null)
                    {
                        maxpred = max;
                        max = max.right;
                    }
                    c.info=max.info;
                    if(max.right == null){
                        p.left = null;
                    }else{
                        maxpred.right = max.left;
                    }
                    c.right = p.right;
                    c.left  = p.left;
                }else if(p.info.compareTo(predp.info)<0){
                    btNode min = p;
                    while(min.left!=null)
                    {
                        min = min.left;
                    }
                    predp.left = min;
                    min.right = p.right;
                }else{
                    btNode min = p;
                    while(min.left != null)
                    {
                        min = min.left;
                    }
                    predp.right=min; 
                    min.right=p.right;
                }/*end of inner if statments*/
            }/*end of if statements */
        }
    }

   public boolean belongs(String i)
   {
      btNode p = c;
      while ((p!=null)&&(!(p.info.equals(i)))) 
      {
         if (p.info.compareTo(i)>0) p = p.left;
         else p = p.right;
      }
      return (p != null); 
   }

   public int get_howmany() {return howmany;}
  
   
   public void print(String outname)
   {
     
        try (PrintWriter outs = new PrintWriter(new FileOutputStream(outname))) {
            outs.println("The number of distinct words is "+howmany);
            outs.println("The total number of words is "+(total+howmany));
            outs.println();
        }
      catch (IOException ex)
      {
      }
   }

   public void print()
   {
        printtree(c);
        if(c == null)
        {
            System.out.println(c);
        }
    }
   
   public boolean equals(BSTMultiStringcoll obj)
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
            outs.println(t.info + " ("+t.count +")" );
            printtree(t.right, outs);
	   }
   }

   /*
   * @param t 
   */
   private static void printtree(btNode t)
   {    
      if(t!=null)
      {   //System.out.print(" Blah " + t.info);
        printtree(t.left);
        System.out.println(t.info +" <---count: "+ t.count);
        if(t.right!=null)
            System.out.println("Right " + t.right.info+" count: "+ t.right.count);
        else
            System.out.println("Right is null" );
        if(t.left!=null)
            System.out.println("Left " + t.left.info+" count: "+ t.left.count);
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
       //  a[num_nodes+i]=t.info;   
        num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 

   private static class btNode
   {
    String info; btNode left; btNode right; int count;

        private btNode(int n,String s, btNode lt, btNode rt)
        {
            count = n; info = s; left = lt; right = rt; 
        }

        private btNode()
        {
            info = null; left = null; right = null; count = 0;
        }
   }
}

