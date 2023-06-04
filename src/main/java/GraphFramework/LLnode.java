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

public class LLnode {
    
    private Edge adjacencyVertex;
    private LLnode next;

    
    
    // ---------------------------------------------
    //               constructor
    // ---------------------------------------------
    public LLnode(Edge adjacencyVertex, LLnode next) {
        this.adjacencyVertex = adjacencyVertex;
        this.next = next;
    }

    public LLnode(Edge adjacencyVertex) {
        this.adjacencyVertex = adjacencyVertex;
    }   
    
    
    // ---------------------------------------------
    //            setters & getters 
    // ---------------------------------------------   

    public Edge getAdjacencyVertex() {
        return adjacencyVertex;
    }

    public void setAdjacencyVertex(Edge adjacencyVertex) {
        this.adjacencyVertex = adjacencyVertex;
    }

    public LLnode getNext() {
        return next;
    }

    public void setNext(LLnode next) {
        this.next = next;
    }




}
