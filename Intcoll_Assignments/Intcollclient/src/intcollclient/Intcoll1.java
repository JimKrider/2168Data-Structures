/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intcollclient;

/**
 *
 * @author Jim
 * 
 */
public class Intcoll1 {
     private int[] c;

     //public Intcoll1 is the Default Constructor
     //C is made into a int array with 501 spaces
   public Intcoll1()
   {
    c = new int[500+1];
    c[0] = 0;
   }

   public Intcoll1(int i)
   {
    c = new int[i+1];
    c[0] = 0;
   }
   
    //Makes a copy of the collection of the object.
   public void copy(Intcoll1 obj)
   {
      	if (this != obj)
      	{
	c = new int[obj.c.length];
	int j = 0;
            while (obj.c[j] != 0)
            {
            c[j] = obj.c[j]; j++;
            }
	c[j] = 0;
	}
   }
   //returns true if i is in the collection, also i has to be greater then 0
   public boolean belongs(int i)
   {
    int j = 0;
    while ((c[j] != 0)&&(c[j] != i)) j++;
    return ((i>0)&&(c[j] == i));
   }
   //this method will insert a number into a array, and make the array larger 
   // if there is not enough room for that number
   public void insert(int i)
   {
    if (i > 0)
    {
    int j = 0;
    while ((c[j] != 0) && (c[j] != i)) j++;
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
    	while ((c[j] != 0)&&(c[j] != i)) j++;
        if (c[j] == i)
      	{
        int k = j+1;
        while (c[k] != 0) k++;
        c[j] = c[k-1]; c[k-1]=0;
      	}
    }
   }
   //Returns how many integers are in the collection
   public int get_howmany()
   {
      	int j=0, howmany=0;

      	while (c[j]!=0) {howmany++; j++;}
      	return howmany;
   }
   // the method will print the array to the screen
   public void print()
   {
      	int j = 0;
      	
      	while (c[j] != 0)
      	{
         	System.out.print(" | "+c[j] ); j++;
      	}
   }
   // this method will compare two arrays and check each number to see if they are equal
   public boolean equals(Intcoll1 obj)
   {
      	int j = 0; boolean result = true;
      	while ((c[j] != 0)&&result)
      	{
         	result = obj.belongs(c[j]); j++;
      	}
      	j = 0;
      	while ((obj.c[j] != 0)&&result)
      	{
         	result = belongs(obj.c[j]); j++;
      	}
      	return result;
   }
    
    
    
}
