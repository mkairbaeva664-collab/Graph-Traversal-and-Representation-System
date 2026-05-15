import java.util.*;

public class Graph {
    private Map<Integer, List<Vertex>> adjList;
    private boolean[] marked;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    private void initMarked() {
        marked = new boolean[1001];
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(new Vertex(to));
        }
    }

    public void bfs(int start) {
        initMarked();
        Queue<Integer> queue = new LinkedList<>();

        marked[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (adjList.size() <= 10) {
                System.out.print(current + " ");
            }

            for (Vertex neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                int w = neighbor.getId();
                if (!marked[w]) {
                    marked[w] = true;
                    queue.add(neighbor.getId());
                }
            }
        }
        if (adjList.size() <= 10) System.out.println();
    }

    public void dfs(int start) {
        if (marked == null) {
            initMarked();
        }

        marked[start] = true;

        if (adjList.size() <= 10) {
            System.out.print(start + " ");
        }

        for (Vertex neighbor : adjList.getOrDefault(start, new ArrayList<>())) {
            int w = neighbor.getId();
            if (!marked[w]) {
                dfs(w);
            }
        }
    }


    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
