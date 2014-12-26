/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll5client;
import java.util.*;
/**
 *
 * @author Jim
 */
public class Intcoll5client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Intcoll5 P = new Intcoll5(), L = new Intcoll5(), N = new Intcoll5();
        Scanner keyboard = new Scanner(System.in);
        int value;
        System.out.println("Enter an integer to be inserted or 0 to quit ");
        value=keyboard.nextInt();
        while(value != 0){
            if(value>0){P.insert(value);L.insert(value);}
            else{N.insert(-value); L.omit(-value);}
            System.out.println("Enter an integer to be inserted or 0 to quit: ");
            value=keyboard.nextInt();
        }   
           
        System.out.print("\nThe values in collection P are: " );
            P.print();
        System.out.print("\nThe values in collection L are: " );
            L.print();
        System.out.print("\nThe values in collection N are: " );
            N.print();
        System.out.print("\nDoes 10 belong in collection L  "+ L.belongs(10));
        System.out.print("\nThe value 10 will be omitted from L: " ); 
        L.omit(10);
        L.print();
      
        Intcoll5 A = new Intcoll5();//A.insert(9);A.insert(15);A.insert(19);
        System.out.print("\nThe values in collection A before copy are:" );
        A.print();
        A.copy(L);
        System.out.print("\nThe values in A with the copy of L are:");A.print();
        System.out.print("\nHow many values are in collection A are:" + A.get_howmany() );
       
        if(P.equals(N)) System.out.println("\nP and N are equal.");
        else System.out.print("\nP and N are Not equal.");
        System.out.print("\nHow many values are in collection P are:" + P.get_howmany() );
        System.out.print("\nHow many values are in collection N are:" + N.get_howmany() );
        System.out.println("\nHow many values are in collection L are:" + L.get_howmany() );
       
    }
}
