/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll4client;

import java.util.Scanner;

/**
 *
 * @author Jimbo
 */
public class Intcoll4client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        // TODO code application logic here
        Intcoll4 P = new Intcoll4(), L = new Intcoll4(), N=new Intcoll4();
        Scanner keyboard = new Scanner(System.in);
        int value;
        System.out.println("Enter an integer to be inserted or 0 to quit ");
          value=keyboard.nextInt();
       
        while(value != 0){
            if(value>0){P.insert(value);L.insert(value);}
            else{N.insert(-value); L.omit(-value);}
            System.out.println("Enter an integer to be inserted or 0 to quit: ");
            value = keyboard.nextInt();
        }   
        System.out.print("\nThe values in collection P are:" );
        P.print();
        System.out.print("\nThe values in collection L are:" );
        L.print();
        System.out.print("\nThe values in collection N are:" );
        N.print();
        System.out.print("\nDoes 10 belong in collection L  "+ L.belongs(10));
        System.out.print("\nThe value 10 will be omitted from L: " ); 
        L.omit(10);
        L.print();
        Intcoll4 B = new Intcoll4();
        B.insert(10);
        B.insert(5);
        System.out.print("\nThe values in collection B before copy are:" );
        B.print();
        B.copy(L);
        System.out.print("\nThe values in B with the copy of L are:");
        B.print();
        System.out.print("\nHow many values are in collection B are:" + B.get_howmany() );
       
        if(P.equals(N)) System.out.println("\nP and N are equal.");
        else System.out.print("\nP and N are Not equal.");
      
        System.out.print("\nHow many values are in collection P are:" + P.get_howmany() );
        System.out.print("\nHow many values are in collection N are:" + N.get_howmany() );
        System.out.println("\nHow many values are in collection L are:" + L.get_howmany() );
    }
    
}
