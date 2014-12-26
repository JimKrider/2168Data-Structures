/*/*
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
public class Intcoll3 {
      private boolean[] c;
      private int howmany=0;
      
     //public Intcoll1 is the Default Constructor
     //C is made into a int array with 501 spaces
   public Intcoll3()
   {    
   c = new boolean[500];
   }

   public Intcoll3(int i)
   {
   c = new boolean[i];
   }
   
    //Makes a copy of the collection of the object.
   public void copy(Intcoll3 obj)
   {
      	if (this != obj)
      	{
		c = new boolean[obj.c.length];
		int j;
		for(j=1; j<c.length-1; j++){
                    c[j] = obj.c[j];
                }
                while (obj.c[j] != false)
		{
		obj.c[j] = true; j++;             
                }
        }
   }
   
   //returns true if i is in the collection, also i has to be greater then 0
   public boolean belongs(int i)
   {    boolean result = false;
         if(i < c.length){
           result = c[i];
        }
       return result;
   }
   //this method will insert a number into a array, and make the array larger 
   // if there is not enough room for that number
   public void insert(int i)
   { 
    if(i<=c.length){
    howmany++;
    int j = 1;
    	while ((c[j] != c[howmany]) && (c[j] != false)) j++; 
	if (c[j] == false)
        {
          if (i == c.length)
          {
          boolean[] d = new boolean[c.length*2];
             for(j = 1;j<c.length;j++)
            {
            d[j]=c[j];
            }
          c = d;
          }
        c[i] = true;
        }
    }else{  
    int j;
    boolean [] d = new boolean[c.length*2];
        for(j = 1 ;j<c.length;j++)
        {
        d[j]=c[j];
        }
    c = d;
     c[i]= true;    
    howmany++;    
    }
   }
   
   //If i is greater then 0 and if i is in the collection it omits
   // i from the collection
   public void omit(int i)
   {
	if (i>0)
	{int j = 1;
      	while ((c[j] != false)&&(i <= c.length)) j++;
            if (c[j] == true)
            {
            howmany--;
            int k = j+1;
            while (c[k] != true) k++;
            c[j] = c[k-1]; c[k-1]=false;
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
      int j;
     
      for(j=1; j<c.length; j++){
      if(true == c[j]){
       System.out.print(" | "+ j );
      }
     }
    }
   // this method will compare two arrays and check each number to see if they are equal
   public boolean equals(Intcoll3 obj)
   {
      	int j = 1; boolean result = true;
    // if(howmany == obj.howmany){
        while ((c[j] != false)&&result)
      	{
         	result = (howmany == obj.howmany); j++;
      	}
     	
   return result;
   }
    
   
   
}

