import java.util.ArrayList;
import java.util.List;

public class DFS {
    // Constants for colors
    private static final int WHITE = 0;
    private static final int GREY = 1;
    private static final int BLACK = 2;

    private int[] color;
    private int[] prev;
    private int[] d;
    private int[] f;
    private int time;

    public DFS(Graph G) {
        int V = G.getNumberOfVertices();
        color = new int[V];
        prev = new int[V];
        d = new int[V];
        f = new int[V];
        time = 0;

        for (int u = 0; u < V; u++) {
            color[u] = WHITE;
            prev[u] = -1;  // Assuming -1 is NIL
            f[u] = Integer.MAX_VALUE;
            d[u] = Integer.MAX_VALUE;
        }

        for (int u = 0; u < V; u++) {
            if (color[u] == WHITE) {
                DFS_Visit(G, u);
            }
        }
    }

    private void DFS_Visit(Graph G, int u) {
        color[u] = GREY;
        time++;
        d[u] = time;

        for (int v : G.getAdjacencyList(u)) {
            if (color[v] == WHITE) {
                prev[v] = u;
                DFS_Visit(G, v);
            }
        }

        color[u] = BLACK;
        time++;
        f[u] = time;
    }

    public static void main(String[] args) {
        // Assume Graph class is implemented and takes number of vertices as a parameter
        // and has a method to add edges
        Graph G = new Graph(5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(1, 4);

        DFS dfs = new DFS(G);

        // Print discovery and finish times for each vertex
        for (int i = 0; i < G.getNumberOfVertices(); i++) {
            System.out.println("Vertex " + i + ": Discovery time = " + dfs.d[i] + ", Finish time = " + dfs.f[i]);
        }
    }
}

class Graph {
    private final int V;
    private final List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public Iterable<Integer> getAdjacencyList(int u) {
        return adj[u];
    }

    public int getNumberOfVertices() {
        return V;
    }
}
