/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcollclient;

import java.util.Scanner;

/**
 *
 * @author Jim
 * 
 */
public class Intcollclient {
    public static final int SENTINEL =0;
    public static final int BELONG = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int value; Scanner keyboard=new Scanner(System.in);
       Intcoll1 P1=new Intcoll1(), N1=new Intcoll1(), L1=new Intcoll1();
       Intcoll2 P2=new Intcoll2(), N2=new Intcoll2(), L2=new Intcoll2();
       Intcoll3 P3=new Intcoll3(), N3=new Intcoll3(), L3=new Intcoll3();
       System.out.println("Enter an integer to be inserted or 0 to quit");
       value=keyboard.nextInt();
       while(value != SENTINEL)
       {
           if(value > 0){P1.insert(value); L1.insert(value);}
           else{N1.insert(-value); L1.omit(-value);}
           if(value > 0){P2.insert(value); L2.insert(value);}
           else{N2.insert(-value); L2.omit(-value);}
           if(value > 0){P3.insert(value); L3.insert(value);}
           else{N3.insert(-value); L3.omit(-value);}
           System.out.println("Enter next integer to be inserted or 0 to quit:");
           value=keyboard.nextInt();
       }
          System.out.print("\nThe values in Intcoll1 P are:");P1.print();
       System.out.print("\nThe values in Intcoll2 P are:");P2.print();
       System.out.print("\nThe values in Intcoll3 P are:");P3.print();
       System.out.print("\nIf the number 20 is in Intcoll1, it will be omitted.");
       if(P1.belongs(20)){System.out.println("20 was in the collection now it is not."); P1.omit(20);P1.print();}
       else System.out.print("\n20 was not in the collection");
       System.out.print("\nThe values in Intcoll1 L are:");L1.print();
       System.out.print("\nThe values in Intcoll1 N are:");N1.print();
       System.out.print("\nThe values in Intcoll2 L are:");L2.print();
       System.out.print("\nThe values in Intcoll2 N are:");N2.print();
       System.out.print("\nThe values in Intcoll3 L are:");L3.print();
       System.out.print("\nThe values in Intcoll3 N are:");N3.print();
       Intcoll2 A=new Intcoll2(); A.copy(L2);
       System.out.print("\nThe values in the copy of Intcoll2 L are: ");A.print();
        if(P2.equals(N2)) System.out.print("\nIntcoll2 P and N are equal.");
       else System.out.print("\nP and N are Not equal.");
       System.out.print("\nThe number of values in Intcoll1 P are:"+ P1.get_howmany());
       System.out.print("\nThe number of values in Intcoll1 N are:"+ N1.get_howmany());
       System.out.print("\nThe number of values in Intcoll1 L are:"+ L1.get_howmany());
       System.out.print("\nThe number of values in Intcoll2 P are:"+ P2.get_howmany());
       System.out.print("\nThe number of values in Intcoll2 N are:"+ N2.get_howmany());
       System.out.print("\nThe number of values in Intcoll2 L are:"+ L2.get_howmany());
       System.out.print("\nThe number of values in Intcoll3 P are:"+ P3.get_howmany());
       System.out.print("\nThe number of values in Intcoll3 N are:"+ N3.get_howmany());
       System.out.println("\nThe number of values in Intcoll3 L are:"+ L3.get_howmany());
       System.out.println("Does " +BELONG+" belong in P: "+ P1.belongs(BELONG));
       System.out.println("Does " +BELONG+" belong in N: "+ N1.belongs(BELONG));
    }

   
        
        
        
    
    
}
