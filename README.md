# Assignment 4: Graph Representation and Traversal System

## A. Project Overview
This project implements a directed graph data structure and evaluates two fundamental search algorithms in Java. The goal is to understand how graphs are represented in memory and how different traversal strategies explore interconnected nodes.

* **Graph Structure**: The project uses a directed graph implemented via an Adjacency List.
* **Vertices and Edges**: Vertices represent individual nodes identified by unique integers. Edges represent the directional connections between these nodes.
* **Overview of BFS and DFS**:
    * **BFS (Breadth-First Search)** explores the graph level-by-level, visiting all immediate neighbors before moving deeper.
    * **DFS (Depth-First Search)** explores as far as possible along each branch before backtracking.

## B. Class Descriptions
* **Vertex**: A simple class that stores the unique ID of a node.
* **Edge**: A class representing a directed link, storing the source and destination vertices.
* **Graph**: The primary class managing the data structure. It uses a `Map<Integer, List<Vertex>>` for the Adjacency List representation. This is more space-efficient than a matrix because it only stores existing edges, allowing O(1) access to a vertex's neighbors.

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
**Step-by-Step Explanation:**
1. Initialize a `boolean[] marked` array to track visited nodes and a `Queue` for exploration.
2. Mark the start node as visited and add it to the queue.
3. While the queue is not empty, remove the front node.
4. For every unvisited neighbor of that node, mark it as visited and add it to the queue.

* **Use Cases**: Finding the shortest path in unweighted graphs and GPS navigation.
* **Time Complexity**: O(V + E), where V is vertices and E is edges.

### 2. Depth-First Search (DFS)
**Step-by-Step Explanation:**
1. Mark the current vertex as visited in the `boolean[] marked` array.
2. Recursively visit each neighbor of the current vertex that has not yet been marked.
3. The recursion naturally uses a stack structure to explore branches to their full depth.

* **Use Cases**: Topological sorting, cycle detection, and solving puzzles (like mazes).
* **Time Complexity**: O(V + E).

## D. Experimental Results

### Execution Time Comparison (Nanoseconds)

| Vertices | BFS Time (ns) | DFS Time (ns) |
| :--- | :--- | :--- |
| 10 | 42,100 | 28,400 |
| 30 | 115,000 | 85,200 |
| 100 | 490,300 | 380,100 |

**Note**: Results were measured using `System.nanoTime()`.

**Observations and Patterns**:
* Both algorithms show linear growth in time as the number of vertices increases, matching the O(V+E) theory.
* In a linear graph structure (0->1->2...), DFS is slightly faster because it avoids the overhead of managing a Queue object.

## E. Screenshots
<img width="717" height="715" alt="ads" src="https://github.com/user-attachments/assets/40ace432-478b-4df0-be2e-91e8f1d6c223" />


## F. Reflection Section
During this assignment, I learned how to translate theoretical graph algorithms from Lecture 9 into functional Java code. One of the key takeaways was the importance of the marked array; without it, the algorithms would fail or enter infinite loops. I also learned that an Adjacency List is a very flexible way to store graph data, especially when using Java's HashMap and ArrayList.

The main difference between the two algorithms is their "priority": BFS prioritizes "width" (neighborhood), while DFS prioritizes "depth" (paths). The biggest challenge was managing the console output. By using a conditional check (adjList.size() <= 10), I was able to keep the output clean for the 30 and 100 vertex tests, focusing on the performance metrics instead of long lists of numbers.
