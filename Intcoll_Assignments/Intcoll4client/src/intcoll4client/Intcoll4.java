/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll4client;



/**
 *
 * @author Jim
 * 
 */
public class Intcoll4 {
    // reference to the head node
    private ListNode c;
    private int howmany=0;
    public Intcoll4()
    {
        howmany = 0;
        c = null; //C is the head of the linked list
    } 
    // Linked list constructor
    private class ListNode
    {
            private int info;
            private ListNode link;
            public ListNode()
            {
                info=0; link=null;
            }
    }
    
    public void copy2(Intcoll4 obj){
        if(this!=obj){
             howmany = this.howmany + obj.howmany;
             ListNode copyOfListNode = this.c;
             ListNode copyOfObjNode = obj.c;
             ListNode copyOfObj;
             while((copyOfObjNode!=null)){
                copyOfObj = new ListNode();
                copyOfObj.info = copyOfObjNode.info;
                copyOfObj.link = copyOfListNode;
                copyOfListNode = copyOfObj;
                       
             copyOfObjNode=copyOfObjNode.link;
           }
             
             this.c=copyOfListNode;
        }else{
            howmany=obj.howmany;
			
           if(obj.c == null){
               c = null;
           }
            c = new ListNode();
            c.info=obj.c.info;
            c.link= obj.c.link;
			
			
        } 
    }
	//MAIN COPY METHOD
	public void copy(Intcoll4 obj){
	if(this!=obj){
            howmany = obj.howmany;
            c = new ListNode();
            ListNode copyOfObjListNode = obj.c;
            ListNode copyOfListNode =c;
            
            while(copyOfObjListNode != null){
            copyOfListNode.info = copyOfObjListNode.info;
            copyOfListNode.link = copyOfObjListNode.link;
            copyOfObjListNode = copyOfObjListNode.link;
            copyOfListNode = copyOfListNode.link;
             }
                       
                    
            
        }else{
            howmany=obj.howmany;
			
           if(obj.c == null){
               c = null;
           }
            c = new ListNode();
            c.info=obj.c.info;
            c.link= obj.c.link;
		}
	}
        
    public void reverse(Intcoll4 obj){
	int middle = 0;
        howmany = obj.howmany;
        if(howmany%2==1){
            middle = howmany/2;
            middle = middle +1;
            howmany = middle-1;
        }else{
            middle= howmany/2;
            howmany=middle;
        }
               System.out.print("\nhowmany"+ middle );
        
            
             ListNode current = obj.c;
             ListNode newList = this.c;
             ListNode reversedPart=null;
             ListNode copyNode;
            // c = new ListNode();
             int count=0;
             int count1=0;
             int count2=0;
              while((count1!=middle)&&(current!=null)){
                 copyNode = new ListNode();
                 copyNode.info=current.info;
                 copyNode.link=current.link;
                 copyNode = copyNode.link;
                 newList =copyNode;
                 count1++;
                 current = current.link;
             }
            while((count!=middle)&&(current != null)){
               count++; 
                ListNode next = current.link;
                 current.link = reversedPart;
                 reversedPart = current;
                current = next;
               newList = reversedPart;
             }
            while((count2!=middle)&&(obj.c!=null)){
                copyNode = new ListNode();
                copyNode.info = obj.c.info;
                copyNode.link= obj.c.link;
                copyNode = copyNode.link;
                
                obj.c=obj.c.link;
                count2++;
                this.c=copyNode;
            }
    }
        
    public void insert(int i){
        if(i>0){
            ListNode p = c;
            while((p!=null)&&(p.info != i))
               p=p.link;
            if(p==null){//To add another ListNode p has to equal null to put i at the end of the linked list
                howmany++;//will increase howmany
                p = new ListNode();//Creates a new node that is added at the end of the list
                p.info=i;//the number in i is added to the info slot of the p node
                p.link=c;//the c node is now linked to the new p node
                c=p;
            }
        }
    }
    public void omit(int i){
      
        if(i>0){
            ListNode tmp =c,pred=null;
        while((tmp!=null)&&(tmp.info!=i)){
            pred = tmp;
            tmp=tmp.link;
        }
            if(tmp!=null){
                howmany--;
                if(pred!=null){
                    pred.link=tmp.link;
                }else{
                    c=tmp.link;
                }
            }
        }
    }
    public boolean belongs(int i){
        boolean result = false;
        if(i>0){
            ListNode p=c;
            while((p!=null)&&(p.info!=i))
                p=p.link;
            result = (p!=null);
        }
        return result;
    }
    
    public int get_howmany(){
        return howmany;
    }
    
    public void print(){
        //System.out.println(howmany);
        ListNode tmp = c;
        if(tmp==null){System.out.print(tmp);}
        while(tmp!=null){
            System.out.print(" |"+tmp.info);
            tmp = tmp.link;
        }
    }
    public boolean equals(Intcoll4 obj){
        boolean result = (howmany == obj.howmany);
        ListNode tmp= c;
        while((tmp!=null)&&result){
            result = obj.belongs(tmp.info);
            tmp=tmp.link;
        }
            
        return result;
    }
}
