
package intcollclient;

/**
 *
 * @author Jim
 * 
 */
public class Intcoll2 {
      private int[] c;
      private int howmany=0;
     //public Intcoll1 is the Default Constructor
     //C is made into a int array with 501 spaces
   public Intcoll2()
   {    
    c = new int[500];
   }

   public Intcoll2(int i)
   {
   c = new int[i];
   }
   
    //Makes a copy of the collection of the object.
   public void copy(Intcoll2 obj)
   {
        if (this != obj)
        {
        c = new int[obj.c.length];
        int j;
            for(j=0; j<c.length-1; j++)
            {
            c[j] = obj.c[j];
            howmany=obj.howmany;
            }
        }	
   }
   //returns true if i is in the collection, also i has to be greater then 0
   public boolean belongs(int i)
   {
    int j = 0;
    while ((c[j] != c[howmany])&&(c[j] != i)) j++;
    return ((i>0)&&(c[j] == i));
   }
   //this method will insert a number into a array, and make the array larger 
   // if there is not enough room for that number
   public void insert(int i)
   {
      	if (i > 0)
	{
	 	howmany++;
                int j = 0;
	     	while ((c[j] != c[howmany]) && (c[j] != i)) j++;
		if (c[j] == 0)
	     	{
			if (j == c.length - 1)
		   	{
                            int [] d = new int[c.length*2];
                            for(j = 0;j<c.length;j++)
                            {
                                d[j]=c[j];
                            }
                        c = d;
                           	
		   	}
                c[j] = i; c[j + 1] = 0;
		}
             
	}
   }
   
   //If i is greater then 0 and if i is in the collection it omits
   // i from the collection
   public void omit(int i)
   {
	if (i>0)
	{   
                
      		int j = 0;
      		while ((c[j] != c[howmany])&&(c[j] != i)) j++;
      		if (c[j] == i)
      		{
                howmany--;
                int k = j+1;
         	while (c[k] != 0) k++;
         	c[j] = c[k-1]; c[k-1]=0;
      		}
	}
   }
   //Returns how many integers are in the collection
   public int get_howmany()
   {
    return howmany;
   }
   // the method will print the array to the screen
   public void print()
   {
    int j=0;
    while(c[j] != c[howmany])
    {
    System.out.print(" | "+c[j] ); j++; 
    }
   }
   // this method will compare two arrays and check each number to see if they are equal
   public boolean equals(Intcoll2 obj)
   {
    int j = 0; boolean result = true;
    while ((c[j] != c[howmany])&&result)
    {
    result = (howmany == obj.howmany); j++;
    }
      	
    return result;
   }
    
   
    
}
