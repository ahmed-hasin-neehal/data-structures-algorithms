import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Sorting edges by weight
    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class DisjointSet {
    int[] parent, rank;
    int n;

    public DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in their own set.
            parent[i] = i;
        }
    }

    // Find the parent of a node 'u'
    // Path Compression
    int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    // Union by rank
    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class KruskalMST {
    // Function to construct and return the MST
    List<Edge> MSTKruskal(List<Edge> edges, int vertices) {
        // Resultant MST
        List<Edge> mst = new ArrayList<>();

        // Sort edges in non-decreasing order
        Collections.sort(edges);

        // Create disjoint sets
        DisjointSet ds = new DisjointSet(vertices);

        for (Edge edge : edges) {
            int x = ds.find(edge.src);
            int y = ds.find(edge.dest);

            // If including this edge does not cause a cycle
            if (x != y) {
                mst.add(edge);
                ds.union(x, y);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        int vertices = 4;

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        KruskalMST kruskal = new KruskalMST();
        List<Edge> mst = kruskal.MSTKruskal(edges, vertices);

        System.out.println("Edges in the MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}
