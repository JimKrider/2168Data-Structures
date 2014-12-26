/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intcoll2client;

import java.util.*;

/**
 *
 * @author Jim
 */
public class Intcoll2client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     Intcoll2 P = new Intcoll2(), L = new Intcoll2(), N=new Intcoll2();
       Scanner keyboard = new Scanner(System.in);
       String userInput;int value;String space = "";
       System.out.println("Enter an integer to be inserted ");
       userInput=keyboard.nextLine();
       
       while(!(userInput.equals(space))){
        value = Integer.parseInt(userInput);
        if(value > 0){P.insert(value);L.insert(value);}
        else{N.insert(-value); L.omit(-value);}
        
        System.out.println("Enter next integer to be inserted: ");
        userInput=keyboard.nextLine();
       
       }       
       System.out.println("\nThe values in collection P are:" );P.print();
       System.out.println("\nThe values in collection N are:" );N.print();
       if(P.equals(N)) System.out.println("\nP and N are equal.");
       else System.out.println("\nP and N are Not equal.");
       
       System.out.println("\nThe values in collection L are:" );L.print();
       System.out.println("Does it belong "+ L.belongs(10));
     
      
       
       System.out.print("\nHow many values are in collection P are:" + P.get_howmany() );
       System.out.print("\nHow many values are in collection N are:" + N.get_howmany() );
       System.out.print("\nHow many values are in collection L are:" + L.get_howmany() );
       
       
       Intcoll2 A=new Intcoll2(); A.copy(L);
       System.out.print("\nThe values in the copy of L are: ");
       A.print();
    
    }
    
}
