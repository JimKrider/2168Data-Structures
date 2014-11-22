
package bstmultistringcoll;
import java.util.*;
import java.io.*;
/**
 *
 * @author Jimbo
 */
public class BSTdictionary {
    public static void main(String[] args)
    {
        try{
            String s;
            int i, j, n, numfiles, c, first, last;
            numfiles= args.length; 
            first   = (int) 'a'; 
            last    = (int) 'z';
            BSTMultiStringcoll AllWords = new BSTMultiStringcoll();
            long allelapsed = 0;
            for (j = 0; j < numfiles-1; j = j+2)
            {
		  	   
                BSTMultiStringcoll Words = new BSTMultiStringcoll();
                boolean yes; String name = args[j];
                BufferedReader ins = new BufferedReader(new FileReader(name));
                Scanner words = new Scanner(ins);
                long start, allstart, stop, allstop, elapsed=0;
                while (words.hasNext())
                {
                    s = words.next(); yes = true;
                    String lower = s.toLowerCase(); 
                    n = lower.length();
                    for (i=0; (i<n-1)&&yes; i++) 
                    {
                        c = (int) lower.charAt(i); 
                        if ((first>c)||(c>last)) yes = false;
                    }
                    c = (int) lower.charAt(n-1);
                    char e = s.charAt(n-1);
                    if (yes &&(n!=1)&&((e=='.')||(e=='?')||(e=='!')||(e==':')||(e==','))) 
                        s = s.substring(0,n-1); 
                    else{
                        if (yes&&((first > c ||(c > last)))) yes = false;
                        }
                    if (yes) 
                    {
                        start      = System.currentTimeMillis(); 
                        Words.insert(s); 
                        stop       = System.currentTimeMillis();
                        elapsed    = elapsed + stop - start;
                        allstart   = System.currentTimeMillis(); 
                        AllWords.insert(s); 
                        allstop    = System.currentTimeMillis();
                        allelapsed = allelapsed + allstop - allstart;
                    }
                }
 	      System.out.print(elapsed/1000.00); 
              System.out.println(" - "+args[j]);
 	      String outname = args[j+1];
 	      Words.print(outname);
 	      ins.close();
            }
        String outname = args[args.length-1];
        AllWords.print(outname);
 	System.out.print(allelapsed); 
        System.out.println(" - " + args[args.length-1]);
    	}
    	catch (IOException ex)
    	{
 	   ex.printStackTrace(System.err); 
           System.exit(1);
    	}
    }
}
