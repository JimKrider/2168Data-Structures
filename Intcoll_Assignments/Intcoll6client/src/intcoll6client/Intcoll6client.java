/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intcoll6client;
import java.util.*;
/**
 *
 * @author Jimbo
 */
public class Intcoll6client
{
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
    Intcoll6 P=new Intcoll6();
    Intcoll6 Q=new Intcoll6();
    int value; Scanner keyboard=new Scanner(System.in);
    System.out.println(
         "Enter a pos integer or neg integer to be inserted or 0 to quit:");
    value=keyboard.nextInt();
    while(value!=0)
    {
       if (value>0) P.insert(value); else Q.insert(-value);
       System.out.println(
         "Enter pos integer or neg integer to be inserted or 0 to quit:");
       value = keyboard.nextInt();
    }
        System.out.println("\nThe values in collection P are:"); 
        System.out.println("\nThe values in collection P after it was omitted are:"); 
        P.print();
        Q.print("Q.out");
   
     
       
   
    




// TODO code application logic here
    }
	
    
}
