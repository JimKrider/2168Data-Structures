/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Random;

/**
 *
 * @author Jim
 */
public class QuickSort {
 static int qcount=0;
 static int rep= 10;
 static int part =0;
 static int array_size=10;
 static long lapse=0, begin, end;
 static int k=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     int test =0;int test1=0;int test2=0; int test3 =0;
     while(test<1){quick2048();test++;}
     while(test1<1){quick4096();test1++;}
     while(test2<1){quick8192();test2++;}
     while(test3<1){quick16384();test3++;}
    }
    
    public static void quick2048(){
        int[] count=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep)
        {
            qcount = 0;
            Random gen=new Random();
            int[] a=new int[2048];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            quicksort(a, 0, a.length-1);
            count[rep10]=qcount;
        rep10++;
        }
        min=count[0];max=count[0];int sum=0;
        for(int j =0; j<count.length; j++){
            if(min>count[j]){
                min = count[j];
            }
            if(max<count[j]){
                max=count[j];
            }
            sum+=count[j];
            average = sum/rep;
    }
        System.out.println("Size 2048  | Min = "+min+"  | Max = "+max 
                + "  | Average "+ average+" | Time in milliseconds "+lapse);
        
      //System.out.print("Qcount--> "+qcount);System.out.println("|Part--> "+part);
    }    
    public static void quick4096(){
       // int rep = 10;
        int[] count=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep){
            qcount =0;
            Random gen=new Random();
            int[] a=new int[4096];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            quicksort(a, 0, a.length-1);
            count[rep10]=qcount;
        rep10++;
        }
        min = count[0];max=count[0];int sum=0;
        for(int j =0; j<count.length; j++){
            if(min>count[j]){
                min = count[j];
            }
            if(max<count[j]){
                max=count[j];
            }
            sum+=count[j];
            average = sum/rep;
        }
        System.out.println("Size 4096  | Min = "+min+"  | Max = "+max 
                + "  | Average "+ average+" | Time in milliseconds "+lapse);
    }
    public static void quick8192(){
       // int rep = 10;
        int[] count=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep){
            qcount =0;
            Random gen=new Random();
            int[] a=new int[8192];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            quicksort(a, 0, a.length-1);
            count[rep10]=qcount;
        rep10++;
        }
        min = count[0];max=count[0];int sum=0;
        for(int j =0; j<count.length; j++){
            if(min>count[j]){
                min = count[j];
            }
            if(max<count[j]){
                max=count[j];
            }
            sum+=count[j];
            average = sum/rep;
        }
        System.out.println("Size 8196  | Min = "+min+"  | Max = "+max 
                + "  | Average "+ average+" | Time in milliseconds "+lapse);
    }
    public static void quick16384(){
       // int rep = 10;
        int[] count=new int[array_size];
        int min,max,average=0;int rep10=0;
        while(rep10<rep){
            qcount =0;
            Random gen=new Random();
            int[] a=new int[16384];
            int i;
            for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
            quicksort(a, 0, a.length-1);
            count[rep10]=qcount;
            rep10++;
      }
        min = count[0];max=count[0];int sum=0;
        for(int j =0; j<count.length; j++){
            if(min>count[j]){
                min = count[j];
            }
            if(max<count[j]){
                max=count[j];
            }
            sum+=count[j];
            average = sum/10;
        }   
        System.out.println("Size 16384 | Min = "+min+" | Max = "+max 
                + " | Average "+ average+" | Time in milliseconds "+lapse);
    }
    
    public static void quicksort(int a[], int l, int h){
        int p;
        
        if((h-l)>0){
            begin=System.currentTimeMillis();
            p = partition(a,l,h);part++;
            quicksort(a,l, p-1);
            quicksort(a, p+1,h);
            end=System.currentTimeMillis();
            lapse=lapse+(end-begin);
        }
    }
    //This is considered a inspace quick sort
    public static int partition( int data[], int l, int h){
        int upper;
        int lower;
        int firsthigh;
       // System.out.print(l);
        upper = l; lower = h; firsthigh=data[l];//Sets first high to the 0 position the top
        while(upper!=lower){
           //  qcount++;
            while((upper<lower)&&(firsthigh>= data[lower]))
               lower--;qcount++;
             if(upper!= lower){
                data[upper]=data[lower];
              }
             
            while((upper<lower)&&(firsthigh <= data[upper]))
               upper++;qcount++;
            if(upper!=lower) {
              data[lower]=data[upper];
            }
          
       }       
        data[upper]=firsthigh;
        return(upper);
    }
    
    
}

