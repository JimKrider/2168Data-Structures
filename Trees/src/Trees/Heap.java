/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author Jimbo
 */
public class Heap {
    private int howmany;
    private btNode c;
    private static int toArray=0;
    
    
    public void heapsort(int[] a)
    {
       int last = a.length; int i;
       for (i = last/2; i>0; i--) maxshift(a, i, last);
       for (i=1; i<a.length; i++)
       {
          int x = a[last-1];
          a[last-1] = a[0];
          a[0]=x;
          last--;
          maxshift(a, 1, last);
       }
    }

    public static void maxshift(int[] a, int i, int last)
    {
        int j=2*i; int x=a[i-1];

        if ((j<last)&&(a[j]>a[j-1])) j++;
        while((j<=last)&&(a[j-1]>x))
        {
            a[i-1]=a[j-1]; i=j; j=2*j;
            if ((j<last)&&(a[j]>a[j-1])) j++;
        }
        a[i-1]=x; 
    }
    public void arrayBTSort(int[] a,int start, int end)
    { 
        c = sortedArrayToBST(a,start,end); 
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
    
    public void btsToArray(int[] a, int i)
    { 
        toarray(this.c,a); 
    }
    
    private static void toarray(btNode t, int[] a)
    {   
        if(t==null){return;}
        toarray(t.left, a);
        a[toArray++] = t.info; 
        toarray(t.right, a);
    }//End of toarray method
    
    
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
