import java.util.LinkedList;
import java.util.Queue;

class Graph {
    int V; // Number of vertices
    int[][] adj; // Adjacency matrix representation
    int[] color, prev, d;
    final int WHITE = 0, GRAY = 1, BLACK = 2;
    final int NIL = -1, INF = Integer.MAX_VALUE;

    public Graph(int V) {
        this.V = V;
        adj = new int[V][V];
        color = new int[V];
        prev = new int[V];
        d = new int[V];
    }

    // Add edge to the graph
    void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1; // Assuming the graph is undirected
    }

    // Breadth-First Search (BFS)
    void BFS(int s) {
        for (int u = 0; u < V; u++) {
            if (u != s) {
                color[u] = WHITE;
                prev[u] = NIL;
                d[u] = INF;
            }
        }
        color[s] = GRAY;
        d[s] = 0;
        prev[s] = NIL;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);

        while (!Q.isEmpty()) {
            int u = Q.remove();
            for (int v = 0; v < V; v++) {
                if (adj[u][v] == 1 && color[v] == WHITE) {
                    color[v] = GRAY;
                    d[v] = d[u] + 1;
                    prev[v] = u;
                    Q.add(v);
                }
            }
            color[u] = BLACK;
        }
    }

    // Print path from source 's' to vertex 'v'
    void printPath(int s, int v) {
        if (v == s) {
            System.out.print(s + " ");
        } else if (prev[v] == NIL) {
            System.out.print("No path");
        } else {
            printPath(s, prev[v]);
            System.out.print(v + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        int source = 0;
        g.BFS(source);

        System.out.println("Shortest path from 0 to 5:");
        g.printPath(source, 5);
    }
}
