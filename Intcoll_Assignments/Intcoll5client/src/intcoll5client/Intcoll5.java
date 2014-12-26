
package intcoll5client;
import java.util.*;
/**
 *
 * @author Jim
 * 
 */
public class Intcoll5 {
    LinkedList<Integer> c;
    
    public Intcoll5()
    {
        c = new LinkedList<>();
    }
    
    public void insert(int i)
    {
        Integer I = i;
        if (!c.contains(I))
        { 
            c.addFirst(I);
        }
    } 
    
    public void omit(int i)
    {
        Integer I = i;
        if(c.contains(I))
        {
            c.remove(I);
        }
    }
    
    public int get_howmany()
    {
        return c.size();
    }
    
    public void copy(Intcoll5 obj)
    {
        ListIterator<Integer> tmp = obj.c.listIterator();
        c = new LinkedList<>();
        while(tmp.hasNext())
        {
            Integer I = tmp.next();
            c.add(I);
	}
    }
    
    public void print()
    {
        ListIterator<Integer> tmp = c.listIterator();
        while(tmp.hasNext())
        {
            Integer I = tmp.next();
            System.out.print(I + " | ");
        }
    }
    
    public boolean belongs(int i)
    {
        Integer I = i;
        return c.contains(I);
    }
    
    public boolean equals(Intcoll5 obj)
    {
    return c.equals(obj.c) ;
    }

}
