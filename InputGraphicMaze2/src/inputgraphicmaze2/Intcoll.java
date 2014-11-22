package inputgraphicmaze2;

import java.util.*;
/**
 * @author Jim
 * 
 */
public class Intcoll {
    LinkedList<Integer> c;
    private int howmany = 0;
    public Intcoll()
    {
        c = new LinkedList<>();
        howmany = 0;
    }
    public Intcoll(int i){
        c = new LinkedList();
        howmany = i;
    }
    
    public void insert(int i)
    {   Integer I = i;
        if (!c.contains(I)){ c.addFirst(I); }
    } 
    public void omit(int i)
    {
        Integer I = i;
        if(c.contains(I)){
            c.remove(I);
        }
    }
    public int get_howmany(){return c.size();}
    public void copy(Intcoll obj)
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
        while(tmp.hasNext()){
            Integer I = tmp.next();
            System.out.print(I + " | ");
        }
    }
    public boolean belongs(int i)
    {
        Integer I = i;
        return c.contains(I);
    }
    public boolean equals(Intcoll obj){ return c.equals(obj.c);}

}
