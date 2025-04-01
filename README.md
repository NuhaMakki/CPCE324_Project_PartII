# 🛢️ Air Freight Optimization using Dijkstra's Algorithm

## 🚀 Project Overview
This project focuses on optimizing **Air Freight Transportation** using **Dijkstra's Algorithm** to solve the **All-Pairs Shortest Path** problem. The objective is to minimize travel distances and optimize delivery times for time-sensitive goods while reducing operational costs. The project was developed as part of the **CPCS 324: Algorithms and Data Structures II** course.

## 🎯 Key Features
- ✅ **Graph Representation:** Reads a directed weighted graph from a file and represents it as an adjacency list.
- ✅ **Random Graph Generation:** Generates graphs with different sizes and edge densities for performance analysis.
- ✅ **Dijkstra’s Algorithm Implementation:** Computes the shortest path between every pair of locations.
- ✅ **Performance Analysis:** Measures and compares execution times for different graph sizes.
- ✅ **Results Printing:** Displays shortest paths with their distances in a structured format.

## 🛠️ Tech Stack
- **Programming Language:** Java

## 📌 System Components
### 🗂️ Graph Representation
The project includes a **Graph Framework** consisting of:
- **Graph Class:** Represents a weighted directed graph with vertices and edges.
- **Vertex Class:** Defines graph nodes representing locations.
- **Edge Class:** Defines weighted connections between locations.


## 🔄 Dijkstra’s Algorithm Implementation
### 🏹 Single-Source Shortest Path Computation
1. **Computation Process:**
   - Implements **Dijkstra’s Algorithm** using a **priority queue (Min-Heap)**.
   - Computes the shortest paths from a starting location to all other locations.
   - Prints the shortest paths and their corresponding distances.

2. **Input Graph:**
   - The graph is loaded from a file using the `readGraphFromFile()` method.
   - All edges represent air routes.
   
   <p align="center">
     <img src="Dijkstra_img/Graph.png" width="80%" alt="Graph Before and After Dijkstra">
   </p>

3. **Screenshots of Output:**
   - Dijkstra’s algorithm computes the shortest path from a selected source node.
   - The resulting graph highlights the shortest paths to all reachable nodes.
   
   <p align="center">
     <img src="Dijkstra_img/output1.png" width="80%" alt="Graph Read from File">
   </p>



---

### 🔁 All-Pairs Shortest Path Computation
1. **Computation Process:**
   - Applies Dijkstra’s Algorithm iteratively for all locations.
   - Displays shortest paths from each location to every other location.

2. **🔬 Graph Generation:**
   - A function `makeGraph(n, m)` generates random directed weighted graphs for:
     - `n=2000` with `m=10000`
     - `n=3000` with `m=15000`
     - `n=4000` with `m=20000`
     - `n=5000` with `m=25000`
     - `n=6000` with `m=30000`

3. **Screenshots of Output 2:**
   - Displays the computed shortest paths for all pairs of vertices.
   
   <p align="center">
     <img src="Dijkstra_img/output2.png" width="80%" alt="Shortest Path Computation">
   </p>

4. **📈 Performance Comparison:**
   - **Execution Time Measurement:**
     - Dijkstra’s Algorithm is run on randomly generated graphs to measure its efficiency.
     - The following table compares experimental and theoretical runtime:
     
     <p align="center">
       <img src="Dijkstra_img/time_efficiency.png" width="80%" alt="Dijkstra Execution Time Comparison">
     </p>

   - **Theoretical vs. Empirical Analysis:**
     - The project compares the observed execution times with the expected theoretical time complexity.
     - Uses a ratio table to evaluate efficiency trends:
     - 
     <p align="center">
       <img src="Dijkstra_img/ratios.png" width="80%" alt="Dijkstra Execution Time Comparison">
     </p>

   - **Analysis of Results:**
     - As the number of vertices (`n`) increases, the empirical time efficiency follows the expected theoretical trend.
     - The ratio of execution time decreases as `n` increases, demonstrating improved efficiency in larger graphs.
     - The difference between empirical and theoretical values decreases, reinforcing the algorithm's scalability.



## 🚀 Getting Started
### 🛠️ Installation & Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/NuhaMakki/Air_Freight_Dijkstra.git
   ```
2. **Open the project in your preferred Java IDE.**
3. **Run the main program `AirFreightApp.java`.**

## 🔍 Usage Guide
- 📂 **Read Graph from File:** Ensure the input file follows the required structure.
- 🔢 **Generate Random Graphs:** Modify `makeGraph()` parameters for testing.
- ⏱️ **Analyze Performance:** Run the program with large datasets to evaluate efficiency.

## 🔥 Conclusion
This project applies **Dijkstra’s Algorithm** to optimize **air freight logistics** by computing the shortest delivery paths. The implementation demonstrates the practical application of **graph algorithms** in transportation networks, improving efficiency and cost-effectiveness.

## 📄 References
- "Introduction to The Design and Analysis of Algorithms" - Anany Levitin

---
📌 **Developed for CPCS 324: Algorithms and Data Structures II**

