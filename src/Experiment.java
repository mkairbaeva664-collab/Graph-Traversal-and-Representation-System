import java.util.ArrayList;
import java.util.List;

public class Experiment {
    private List<String> results = new ArrayList<>();

    public void runTraversals(Graph g, int size) {
        long startBfs = System.nanoTime();
        g.bfs(0);
        long bfsTime = System.nanoTime() - startBfs;

        long startDfs = System.nanoTime();
        g.dfs(0);
        long dfsTime = System.nanoTime() - startDfs;
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph g = new Graph();

            for (int i = 0; i < size; i++) {
                g.addVertex(new Vertex(i));
            }

            for (int i = 0; i < size - 1; i++) {
                g.addEdge(i, i + 1);
            }

            if (size == 10) {
                g.printGraph();
                System.out.println("--- Traversal Order (Small Graph) ---");
            }

            long startBfs = System.nanoTime();
            g.bfs(0);
            long timeBfs = System.nanoTime() - startBfs;

            long startDfs = System.nanoTime();
            g.dfs(0);
            long timeDfs = System.nanoTime() - startDfs;

            if (size == 10) {
                System.out.println("------------------------------------\n");
            }

            results.add(size + "\t\t" + timeBfs + "\t\t" + timeDfs);
        }
    }

    public void printResults() {
        System.out.println("=== PERFORMANCE RESULTS ===");
        System.out.println("Size\t\tBFS (ns)\tDFS (ns)");
        for (String res : results) {
            System.out.println(res);
        }
    }
}
