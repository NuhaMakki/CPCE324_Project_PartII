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



package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

////this class is a subclass of Graph
public class AFRouteMap extends Graph{
   
    // ---------------------------------------------
    //            variables declaration 
    // ---------------------------------------------
    int num= 0; // to get a unique number for the city

    
    
    // ---------------------------------------------
    //               constructor
    // ---------------------------------------------                
    public AFRouteMap (boolean isDigraph, int veticesNo, int edgeNo) {
        super(isDigraph, veticesNo, edgeNo);
    }

    public AFRouteMap() {
        super();
    }
    


    // ---------------------------------------------
    //                   functions
    // ---------------------------------------------
    //this method to create Routes
    @Override
    public Edge createEdge(Vertex source, Vertex target, int weghit) {
        return new Route( (Location)source, (Location)target, weghit);
    }
    
    
    //this method to create Locations
    @Override
    public Vertex createVertex(String lable) {
        Location Loc = new Location(lable);
        Loc.setCity(++num);
        return Loc; 
    }

    
}


