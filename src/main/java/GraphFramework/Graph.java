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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

//this class defines the structure of a graph
public abstract class Graph {
    
    // ---------------------------------------------
    //            variables declaration 
    // ---------------------------------------------
    int veticesNo;  // number of vertices of the graph
    int edgeNo; // number of edges of the graph
    boolean isDigraph; // true ==> directed graph   ||   false ==> undirected graph    
    ArrayList<Vertex> vertices = new ArrayList<Vertex>();  //represents the list of vertices of a graph

    
    
    
    // ---------------------------------------------
    //                  constructor
    // --------------------------------------------- 

    public Graph(boolean isDigraph, int veticesNo, int edgeNo) {
        // veticesNo = veticesNo;
        // edgeNo = edgeNo;
        this.isDigraph = isDigraph;
    }

    public Graph() {
        this.isDigraph=false;
    }
    

    // ---------------------------------------------
    //            setters & getters 
    // ---------------------------------------------    

    public int getVeticesNo() {
        return veticesNo;
    }

    public void setVeticesNo(int veticesNo) {
        this.veticesNo = veticesNo;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    public boolean isIsDigraph() {
        return isDigraph;
    }

    public void setIsDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }
    
    public Vertex containsVertices(String str) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getLabel().equals(str))
                return vertices.get(i);
        }
        return null;
    }    
    

    
    
    
    // ---------------------------------------------
    //                   functions 
    // ---------------------------------------------   
    

    // This method creates a random graph
    // takes as parameters the number of vertices and the number of edges
    public void makeGraph(int verticesNo, int edgesNo) {     
        
        //for loop to create vertices, add them to the list
        for (int i = 1; i <= verticesNo; i++) {
                this.vertices.add(createVertex(  ""+i )  ); // add vertex to vertices list
                this.veticesNo++; //increments the veticesNo by one
        }
        
        // shuffle the list
        Collections.shuffle(this.vertices);
        Random random = new Random();// create Random object.. used to get random 
        int i = 0;
        int j = 1;
        int count =0;        
        while(edgeNo<edgesNo){
            // create edges
            addEdge( vertices.get(i), vertices.get(j), (random.nextInt(1, 10000))   );
            // increment i, j
            i = (i + 1) % vertices.size();
            j = (j + 1) % vertices.size();
            count++;             
            // reset i=0 & j with new value to get distenct 
            if (count== vertices.size()){
                j++;
                count=0; 
            }
            
        }    

    }// End makeGraph method
    // ---------------------------------------------   

   
     
    // This method reads the edges and vertices from the text file and place data in a Graph
    public void readGraphFromFile(Scanner read) {     

        // while loop to read all graph's edges from file
        while (read.hasNext()){    
            
            //SourseOffice
            String SourseOffice = read.next(); //read SourseOffice
            Vertex source = getVertex (SourseOffice); // this method return the vertex (creat it if not exist)
            
            //targetOffice
            String targetOffice = read.next(); // read targetOffice
            Vertex target = getVertex (targetOffice); // this method return the vertex (creat it if not exist)
            
            //Read the weight
            int weight= read.nextInt(); 
            this.addEdge(source, target, weight); // this method creates an edge object
        }
    }// End readGraphFromFile method
    // ---------------------------------------------   
    
    
    // This method used in readGraphFromFile
    // it checks:  IF vertex already exist ==> return vertex   ||    ELSE ==> creat vertex then return it
    public Vertex getVertex (String vLable) {   
        Vertex v = this.containsVertices(vLable); //check:  IF vertex already exist ==> get vertex
            if (v==null){ // if not exist
                v= this.createVertex(vLable); //creat vertex
                this.vertices.add(v); // add vertex to vertices list
                this.veticesNo++; //increments the veticesNo by one
            }
        return v;
    }// End getVertex method
    // ---------------------------------------------   
    
    
    
    // This function creates an edge object
    // source vertex v, the target vertex u and w the vertex weight as parameters  
    public void addEdge(Vertex v, Vertex u, int w) {   
        //creates an edge object
        Edge edge = this.createEdge(v, u, w);
        //assigns the target vertex to the adjacent list of the source vertex
        v.getAdjList().insertNode(edge);        
        this.edgeNo++; //increments the EdgeNo by one
        
        //if the graph is undirected ==> add the source vertex to the adjacent list of the target vertex
        if (!isDigraph){
            u.getAdjList().insertNode(edge);        
            this.edgeNo++; // //increments the EdgeNo again if it is an undirected graph
        }
    }// End addEdge method
    // ---------------------------------------------   
     
    
    // this method to createEdge
    // has been overridden in Line class
    public abstract Edge createEdge(Vertex source, Vertex target, int weghit);
    // End createEdge method
    // ---------------------------------------------   

    
    // this method to createVertex
    // has been overridden in Office class
    public abstract Vertex createVertex(String lable);
    // End Vertex method
    // ---------------------------------------------   

   
}//End of class
