/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author Jim
 */
public class BinaryTree {
    private  int howmany;
    private btNode c;
    
    public BinaryTree()
    {
      c = null;
      howmany = 0;
    }
    public BinaryTree(int i)
    {
      c = null;
      howmany = 0;
    }   
    
    public int largerThen(int n){
      return largerThen(c,n);
    }
    
    private static int largerThen(btNode t,int n)
    {
        int count = 0;
        if(t == null){return count;}
        if(t.info > n)
        {
            count++;
        }
        return count + largerThen(t.left,n)+largerThen(t.right,n);
    }

    public void largerThenOmit(int i)
    {
        remove(c,i);
    }
    
    private void remove(btNode t,int i)
    {   btNode p = c;
       // if(t == null){return;}
        int count=0;
        /* I can count the depth if it is the max depth then it is root.
        If it is less then max it is not root
        */
        if((t.info == i)&&(t.left.info < i)&&(c.info != t.info)){
            c.right = t.left;
            c.right.info = t.left.info;
           
        }else if((t.info == i)&&(c.info == t.info)){
            c = t.left;
            c.info = t.left.info;
            if(t.left.right!=null){
                c.right = t.left.right;
            }
            System.out.println("test");
        }else if((t.info!=i)&&(t.right.info>=i)){
             t.right = null;
        }else if(t.info > i){
            remove(t.left,i);
        }else if(t.info < i){
            remove(t.right,i);
        }
        
        
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
    
    /*Not Going to use this anymore*/
    private static btNode omit(btNode t, int i){
        if(t == null) return t;
        if(t.info > i){t.left=omit(t.left, i);}
        else if(t.info < i){t.right=omit(t.right,i);}
        else if(t.left != null && t.right != null){
            t.info  = findMin(t.right).info;
            t.right = omit(t.right,t.info);
        }else{t = (t.left != null) ? t.left : t.right;}        
        return t;
    }
    private static btNode findMin( btNode t ){
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        
        return findMin( t.left );
    }
    private static btNode findMax( btNode t ){
        if( t != null )
            while( t.right != null )
                t = t.right;
        return t;
    }
    
    
    public int get_howmany() {return howmany;}//End of get_howmany   
    public void print(){
        printtree(c);
        System.out.println("Root-->"+c.info);
        if(c == null){System.out.println(c);}
    }//End of print    
    private static void printtree(btNode t){    
      if(t != null){  
        printtree(t.left);
        System.out.println(t.info);
        printtree(t.right);
      } 
    }//End of Printtree method   
    
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
