public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        for (int i = 0; i < 5; i++) graph.addVertex(new Vertex(i));
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("Graph Structure:");
        graph.printGraph();

        System.out.println("BFS starting from 0:");
        graph.bfs(0);

        System.out.println("DFS starting from 0:");
        graph.dfs(0);
    }
}
