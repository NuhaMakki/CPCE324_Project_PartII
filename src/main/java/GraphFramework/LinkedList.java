/*
Department of Computer Science
CPCS 324: Algorithms and Data Structures (II) 
Spring 2023 Group Project – Part II
Implement Dijkstra algorithm and using it to compute the all-pair-source shortest path problem

---------------------------------------
Name           | ID         | Section
---------------------------------------
Nuha Makki     | 2024579    | B8	   
Rawan Algamdi  | 2005446    | B8		   
Rawan Aljedani | 1906454    | B0B	
Joud Alahmadi  | 2006214    | B0B		   
---------------------------------------

project link on GitHub:
https://github.com/NuhaMakki/CPCE324_Project_PartII.git


*/


package GraphFramework;

public class LinkedList {

    // head: reference variable to the first node of the list
    private LLnode head;

    // ---------------------------------------------
    //                  constructor
    // ---------------------------------------------    
    public LinkedList() {
        head = null;
    }

    public LLnode getHead() {
        return head;
    }

    
    // ---------------------------------------------
    //                  functions
    // ---------------------------------------------        
    
    public void insertNode(Edge edge){
        // insert first node
        if (head == null){
            head = new LLnode (edge);
        }
        
        //insert the node at the end of the linkedList
        else{
            LLnode hptr=head;
            while(hptr.getNext() != null){
                hptr=hptr.getNext();
            }
            hptr.setNext(new LLnode (edge));
        }
    }
    // ---------------------------------------------        

    
    
    
}
