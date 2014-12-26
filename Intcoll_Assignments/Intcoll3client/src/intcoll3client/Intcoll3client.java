/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intcoll3client;

import java.util.*;

/**
 *
 * @author Jim
 * 
 */
public class Intcoll3client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     Intcoll3 P = new Intcoll3(), L = new Intcoll3(), N=new Intcoll3();
       Scanner keyboard = new Scanner(System.in);
       //int value;
       int value;
       System.out.println("Enter an integer to be inserted or 0 to quit ");
       
       value=keyboard.nextInt();
       
       
       while(value != 0){
          
          if(value>0){P.insert(value);L.insert(value);}
          else{N.insert(-value); L.omit(-value);}
        
        System.out.println("Enter an integer to be inserted or 0 to quit: ");
        value=keyboard.nextInt();
       
       }       
       System.out.println("\nThe values in collection P are:" );P.print();
       System.out.println("\nThe values in collection N are:" );N.print();
       if(P.equals(N)) System.out.println("\nP and N are equal.");
       else System.out.println("\nP and N are Not equal.");
       
       System.out.println("\nThe values in collection L are:" );L.print();
       System.out.println("Does it belong 10 in collection L  "+ L.belongs(10));
     
       System.out.print("\nHow many values are in collection P are:" + P.get_howmany() );
       System.out.print("\nHow many values are in collection N are:" + N.get_howmany() );
       System.out.print("\nHow many values are in collection L are:" + L.get_howmany() );
       
       
       Intcoll3 A=new Intcoll3(); A.copy(L);
       System.out.print("\nThe values in the copy of L are: ");
       A.print();
    }
    
}

