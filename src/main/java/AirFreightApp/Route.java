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

//this class is a subclass of Edge
public class Route extends Edge{
    // ---------------------------------------------
    //            variables declaration 
    // ---------------------------------------------


    // ---------------------------------------------
    //               constructor
    // --------------------------------------------- 

    public Route(Location source, Location target, int weghit ) {
        this.setSource(source);
        this.setTarget(target);
        this.setWeight(weghit);
    }

    
    
    
    
    // ---------------------------------------------
    //                   functions 
    // ---------------------------------------------   
    
    @Override
     public void displayInfo(){     
        System.out.print(" --- route length: ");
        super.displayInfo();
    }
    
}



