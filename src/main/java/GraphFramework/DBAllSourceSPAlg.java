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

// DBAllSourceSPAlg: is a subclass of ShortestPathAlgorithm
public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
        
    // ---------------------------------------------
    //            variables declaration 
    // ---------------------------------------------

    double StartTime;
    double FinishTime; 

    // DBAllResult: Represents the final result list of Dijkstra algorithm for all vertices
    // Each index in DBAllResult list represents a vertex of the graph
    // containes Array of eddges for a single source shortest path
    ArrayList<ArrayList<Edge>> DBAllResult = new ArrayList<ArrayList<Edge>>(); 
    
    
    // ---------------------------------------------
    //               constructor
    // ---------------------------------------------
    
    public DBAllSourceSPAlg(Graph graph) {
        this.graph = graph;
    }
    

    // ---------------------------------------------
    //                   functions 
    // ---------------------------------------------   


    public void computeDijkstraBasedSPAlg(){

        //Start time
        StartTime = System.currentTimeMillis();
        
            //loop to call SingleSourceSPAlg for each vertex of the graph
            for (int i = 0; i < graph.veticesNo ; i++) {
                //creating SingleSourceSPAlg object
                SingleSourceSPAlg SingleSource = new SingleSourceSPAlg(graph);
                
                //call computeDijkstraAlg method
                SingleSource.computeDijkstraAlg(i); 
                
                //add the result to DBAllResult list
                DBAllResult.add(SingleSource.result);
            }
            

            //Finish time of the algorithm
            FinishTime = System.currentTimeMillis();

            //printing time
            displayTime();
        
    }// end of computeDijkstraBasedSPAlg
    // --------------------------------------------- 
    


        
    // this method used in displayResult to display all shortest path for all verteces
    public void displayTime(){
        System.out.printf("#n= %-10s#m= %-10s Total RunTime: " , 
                graph.getVeticesNo(),graph.getEdgeNo()  );
        System.out.println((FinishTime-StartTime) +".ms");
        System.out.println("---------------------------------------------------------------------------------------\n");
    }// end of computeDijkstraBasedSPAlg
    // --------------------------------------------- 

        

    // this method to display all shortest path for all verteces
    public void displayResult(){
        Edge p; String s="";
        ArrayList<Edge> result;
        for (int i = 0; i < DBAllResult.size()-1; i++) {
            result =  DBAllResult.get(i);       
            System.out.println("The starting point location is " + DBAllResult.get(i).get(0).getSource().label + "\n"+
                        "The routes from location " + DBAllResult.get(i).get(0).getSource().label +" to the rest of the locations are:");
                for (int j = 0; j < result.size(); j++) {
                    print(result.get(j));
                    result.get(j).displayInfo();
                    System.out.println("");
                }
            System.out.println("\n---------------------------------------------------------------------------------------\n");
        }
    }// end of displayResult
    // --------------------------------------------- 
    
    
    
    // this method used in displayResult to display all shortest path for all verteces        
    public void print(Edge e){
        if (e.getBrev()==null){
            e.getSource().displayInfo();
            System.out.print("- ");                
            e.getTarget().displayInfo();
        }
        else{
            print(e.getBrev());
            System.out.print("- ");
            e.getTarget().displayInfo();

        }

    }// end of print
    // ---------------------------------------------         
    
        
}// End of DBAllSourceSPAlg class
        













