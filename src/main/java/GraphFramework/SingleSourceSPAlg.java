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

import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;



//SingleSourceSPAlg: is a subclass of ShortestPathAlgorithm
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    

    // ---------------------------------------------
    //            variables declaration 
    // ---------------------------------------------
    ArrayList<Edge> result = new ArrayList<Edge>();  //represents the result for singl source shortest path
    ArrayList<Vertex> unVesitedVertex = new ArrayList<Vertex>();  //represents the unvesited Verteces
    ArrayList<Edge> AdjEdges = new ArrayList<Edge>();  //represents the adjcent edge
    Vertex minVertex; // represents the vertex with minmum cost to be removed from list
    ArrayList<Vertex> visitedVertices = new ArrayList<Vertex>();;  //represents the visited Vertices
    int sum=0;// used by DijkstraAlg to calculate Distances
    // ---------------------------------------------
    //               constructor
    // ---------------------------------------------
    public SingleSourceSPAlg(Graph graph) {
        this.graph = graph;
        CopyVertex();        
    }
  
    // ---------------------------------------------
    //                   functions 
    // --------------------------------------------- 
    

    public void computeDijkstraAlg(int index){
        Vertex source = graph.getVertices().get(index);//get source Vertex from graph
        source.setDistance(0);// set source Distance = 0
        Collections.sort(unVesitedVertex, Comparator.comparingInt(o -> o.getDistance()) );// sort list
        
        // for each vertex in the graaph
        for (int i = 0; i < graph.veticesNo; i++) {
            minVertex = unVesitedVertex.remove(0); //remove vertex with minmum cost from list
            visitVertex(minVertex); // insert minVertex in the visited Vertices List
            insertadjacencyVertex(minVertex); //inserts djacency Verteces to minVertex in the adjEdge
            
            // for all adjacency Verteces
            while(!AdjEdges.isEmpty()){
                
                // calculate Distance from of this edge to vertex
                sum = AdjEdges.get(0).weight+AdjEdges.get(0).getSource().getDistance();
                // check if Distance of this edge to vertex less than the already assignd Distance
                if (  sum < AdjEdges.get(0).getTarget().getDistance()){
                    // if so:
                    AdjEdges.get(0).getTarget().setDistance(sum);//reset Distance = calculated Distance
                    AdjEdges.get(0).getTarget().setParent(AdjEdges.get(0).getSource()); // re set the vertex parent to edge source
                }
                sum = 0; // reset sum
                AdjEdges.remove(0); // remove edge from list
            }
            //sorting
            Collections.sort(unVesitedVertex, Comparator.comparingInt(o -> o.getDistance()) );

        }
        
        // inserts final Edges in the result List
        addEdges();
    }// End of CopyVertex method
    // ---------------------------------------------

        
     
    // this method to copy vertices from graph to unVesitedVertex
    // also, to set graph vertices atribuetes
    public void CopyVertex(){
        for (int i = 0; i < graph.veticesNo; i++) {
            graph.vertices.get(i).setDistance(MAX_VALUE);
            graph.vertices.get(i).setParent(null);               
            graph.vertices.get(i).setIsVisited(false);               
            unVesitedVertex.add(graph.vertices.get(i));

        }
    }// End of computeDijkstraAlg method
    // ---------------------------------------------


        
    //this method inserts vertex in the visited Vertices List 
    public void visitVertex(Vertex v){
        v.setIsVisited(true);
        visitedVertices.add(v);
    }// End of visitVertex method
    // ---------------------------------------------
    

    //this method inserts final Edges in the result List
    public void addEdges(){
        Edge e;
        for (int i = 1; i < visitedVertices.size(); i++) {
            if (visitedVertices.get(i).getDistance() < MAX_VALUE &&  visitedVertices.get(i).getDistance() > 0){
                e=(graph.createEdge(visitedVertices.get(i).getParent(), 
                    visitedVertices.get(i), visitedVertices.get(i).getDistance()));
                e.setBrev(getEdge(visitedVertices.get(i).getParent()));
                result.add(e);
            }            
        }
    }// End of addEdges method
    // ---------------------------------------------    
    
    
    //this method used in addEdges inserts final Edges in the result List
    public Edge getEdge (Vertex v) {   
        Edge e=null;
        for (int i = result.size()-1; i >= 0; i--) {
            if (result.get(i).target==v){
                e = result.get(i);
                break;
            }
        }
        return e;

    }// End getVertex method
    // ---------------------------------------------   
    
    
    //this method inserts djacency Verteces in the adjEdge
    public void insertadjacencyVertex(Vertex v){
        LLnode hptr = v.getAdjList().getHead();
        while (hptr!=null) {
            if (!hptr.getAdjacencyVertex().getTarget().isVisited){
                AdjEdges.add(hptr.getAdjacencyVertex());
            }
            hptr=hptr.getNext();
        }
    }// End of insertadjacencyVertex method
    // ---------------------------------------------  
    

   
  
}// End of SingleSourceSPAlg class
// ---------------------------------------------


