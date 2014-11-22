2168 Data-Structures Class Programs
===================

##BSTMultiStringColl

Simple Program that was given to the class by Professor Korsh. 

I applied the `BSTMultiStringColl` class to the `BSTdictionary`. With a few small modifications.

One of the changes was.
```java
private int total;
```
This was added so I was able to Calculate the Total number of words. 

```java
 if((p.info.equals(i))){
                p.count = p.count+1;
                total++;
                break;
  }
```
`total` was used in this if statement, where I also added a break statement, which was used to break the 
statement when a string was already in the BST
