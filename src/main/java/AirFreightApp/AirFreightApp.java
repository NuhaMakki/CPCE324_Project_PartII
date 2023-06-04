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

// this class is the starting point of the program and contains the main function

import GraphFramework.DBAllSourceSPAlg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirFreightApp {
  

    
    public static void main(String[] args) throws FileNotFoundException {
        
        
    // ---------------------------------------------
    //               requirement 1
    // ---------------------------------------------
        
        //--------------------------------------------------
        //creating File opjects for readGraphFromFile method
        File input = new File("graphFile.txt");
        
        // check if files exist
        if (!input.exists()){
            System.out.println("File not found");
            System.exit(0);
        }// end if
        
        // create scanner to read from file
        Scanner read = new Scanner(input);
        //--------------------------------------------------
        
        
        //--------------------------------------------------       
        //reading from file
        String str = read.next();
        if (str.equalsIgnoreCase("digraph")){
            int isDig = read.nextInt();
            boolean isDigraph = (isDig != 0);            
            int veticesNo = read.nextInt();
            int edgeNo = read.nextInt();
            
            //creating new garhph
            AFRouteMap graph = new AFRouteMap(isDigraph, veticesNo, edgeNo );
            
            // invoking readGraphFromFile method
            graph.readGraphFromFile(read);
            
            //printing header
            printHeader(1);
            
            // creating DBAllSourceSPAlg object, invoking method & displaying ResultingMST
            DBAllSourceSPAlg DBAllSourceSPAlg = new DBAllSourceSPAlg(graph);
            DBAllSourceSPAlg.computeDijkstraBasedSPAlg();
            DBAllSourceSPAlg.displayResult();
              
        } //end if
         
       

        
    // ---------------------------------------------
    //               requirement 2
    // --------------------------------------------- 
    
        //printing header
        printHeader(2);

        
        //this is 2D array to store 5 different casses of graphs
        int GraphsCases [][] = { {2000, 10000}, {3000, 15000}, {4000,  20000},
                                 {5000, 25000}, {6000, 30000} };

        for (int i = 0; i < GraphsCases.length; i++) {
        
            //making new garhph
            AFRouteMap graph = new AFRouteMap();    
            // invoking makeGraph method
            graph.makeGraph(GraphsCases[i][0], GraphsCases[i][1]);              

            // creating DBAllSourceSPAlg object, invoking method 
            DBAllSourceSPAlg DBAllSourceSPAlg = new DBAllSourceSPAlg(graph);
            DBAllSourceSPAlg.computeDijkstraBasedSPAlg();

        }

    }    // End main method
    // ----------------------------------------------------------------------------------------------------------------------------
 
    
    
    
    
    //printing method
    public static void printHeader(int i){
         System.out.println("***********************************************************************************************************\n"
                           + "*****************************************      requirement "+i+"      *****************************************\n"+
                            "***********************************************************************************************************\n\n\n"       
                            +" ---------------------------------------------------------------------------------------\n");

    } 
    // --------------------------------------------- 
    
}// class End





/*
Extra Specifications:
    *  Visual Studio Code
    * GitHab
    * hardware configuration (for the device used in copmuting the rinTime):
        - Hardware type: Asus ZenBook Flip 13 UX363EA
        - Processor: 11th Gen Intel(R) Core(TM) i7-1165G7 @ 2.80GHz 2.80 GHz
        - RAM: 16.0 GB (15.7 GB usable)
        - System Type: 64-bit operating system, x64-based processor
    * operating system: Windows
        - Edition: Windows 11 Home
        - Version: 21H2
        - OS build: 22000.1574
*/