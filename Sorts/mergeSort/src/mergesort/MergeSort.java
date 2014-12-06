/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;


import java.util.Random;

/**
 *
 * @author Jim
 */
public class MergeSort {
   static int numcalls=0;
   static int count=0, m=0;
   static int rep=10;
   static int array_size=10;
   static long lapse=0, begin, end;
    static int k=0;
   public static void main(String[] args)
   {
       int test =0;int test1=0;int test2=0;int test3 =0;
      while(test<1){merge2048();test++;}
      while(test1<1){merge4096();test1++;}
      while(test2<1){merge8192();test2++;}
      while(test3<1){merge16384();test3++;}
   }
   
   public static void merge2048(){
        int[] countm=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep){
            numcalls =0;
            Random gen=new Random();
            int[] a=new int[2048];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            mergesort(a, 0, a.length-1);
            countm[rep10]=numcalls;
        rep10++;
        }
        min = countm[0];max=countm[0];int sum=0;
        for(int j =0; j<countm.length; j++){
            if(min>countm[j]){
                min = countm[j];
            }
            if(max<countm[j]){
                max=countm[j];
            }
            sum+=countm[j];
            average = sum/rep;
        }
        System.out.println("Size 2048   | Min = "+min+"   | Max = "+max 
                + "   | Average "+ average+" | Time in milliseconds "+lapse);
    /*
    System.out.print("Numcalls--> "+numcalls);
    System.out.println("| count--> "+count+"| m--> "+m);*/
   }
   public static void merge4096(){
        int[] countM=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep){
            numcalls =0;
            Random gen=new Random();
            int[] a=new int[4096];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            mergesort(a, 0, a.length-1);
            countM[rep10]=numcalls;
        rep10++;
        }
        min = countM[0];max=countM[0];int sum=0;
        for(int j =0; j<countM.length; j++){
            if(min>countM[j]){
                min = countM[j];
            }
            if(max<countM[j]){
                max=countM[j];
            }
            sum+=countM[j];
            average = sum/rep;
        }
        System.out.println("Size 4095   | Min = "+min+"   | Max = "+max 
                + "   | Average "+ average+" | Time in milliseconds "+lapse);
    
    /*System.out.print("Numcalls--> "+numcalls);
    System.out.println("| count--> "+count+"| m--> "+m);*/
   }
   public static void merge8192(){
        int[] countm=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep){
            numcalls =0;
            Random gen=new Random();
            int[] a=new int[8192];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            mergesort(a, 0, a.length-1);
            countm[rep10]=numcalls;
        rep10++;
        }
        min = countm[0];max=countm[0];int sum=0;
        for(int j =0; j<countm.length; j++){
            if(min>countm[j]){
                min = countm[j];
            }
            if(max<countm[j]){
                max=countm[j];
            }
            sum+=countm[j];
            average = sum/rep;
        }
        System.out.println("Size 8192   | Min = "+min+"  | Max = "+max 
                + "  | Average "+ average+" | Time in milliseconds "+lapse);
    /*System.out.print("Numcalls--> "+numcalls);
    System.out.println("| count--> "+count+"| m--> "+m);*/
   }
   public static void merge16384(){
        int[] countm=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep){
            numcalls =0;
            Random gen=new Random();
            int[] a=new int[16384];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            mergesort(a, 0, a.length-1);
            countm[rep10]=numcalls;
        rep10++;
        }
        min = countm[0];max=countm[0];int sum=0;
        for(int j =0; j<countm.length; j++){
            if(min>countm[j]){
                min = countm[j];
            }
            if(max<countm[j]){
                max=countm[j];
            }
            sum+=countm[j];
            average = sum/rep;
        }
        System.out.println("Size 16384  | Min = "+min+"  | Max = "+max 
                + "  | Average "+ average+" | Time in milliseconds "+lapse);
    /*System.out.print("Numcalls--> "+numcalls);
    System.out.println("| count--> "+count+"| m--> "+m);*/
   }
   
   public static void mergesort(int[] a, int top, int bottom)
   {
	  numcalls++;
      if (top!=bottom)
      {
         int middle=(top+bottom)/2;
         begin=System.currentTimeMillis();
         mergesort(a, top, middle);
         mergesort(a, middle+1, bottom);
         merge(a, top, bottom);
         end=System.currentTimeMillis();
         lapse=lapse+(end-begin);
      }
   }

   public static void merge(int[] a, int top, int bottom)
   {
      int t=top; int middle=(top+bottom)/2; int b=middle+1; int i=0;
      int[] s=new int[bottom-top+1];
      while ((t<=middle)&&(b<=bottom))
      {
         if (a[t]<a[b])
         {
            s[i]=a[t]; t++;
         }
         else
         {
            s[i]=a[b]; b++;
         }
         i++; count++; m++;
      }
      int last=middle;
      if (b<=bottom) {t=b; last=bottom;}
      while (t<=last)
      {
         s[i]=a[t]; t++; i++; m++;
      }
      for (i=0; i<s.length; i++) {a[i+top]=s[i]; m++;}
   }
    
}
