import java.util.Arrays;

public class PrimMST {
    private static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with the smallest key value, from the set of vertices not yet included in MST
    private static int extractMin(int[] key, boolean[] inMST, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print the constructed MST stored in parent[]
    private static void printMST(int[] parent, int[][] graph, int V) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Function to construct and print MST for a graph represented using adjacency matrix representation
    public static void primMST(int[][] graph, int V) {
        // Array to store constructed MST
        int[] parent = new int[V];

        // Key values used to pick minimum weight edge in cut
        int[] key = new int[V];

        // To represent set of vertices included in MST
        boolean[] inMST = new boolean[V];

        // Initialize all keys as INFINITE
        Arrays.fill(key, INF);

        // Always include first 1st vertex in MST.
        // Make key 0 so that this vertex is picked as first vertex.
        key[0] = 0;
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = extractMin(key, inMST, V);

            // Add the picked vertex to the MST Set
            inMST[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not yet included in MST
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non zero only for adjacent vertices of u
                // inMST[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // print the constructed MST
        printMST(parent, graph, V);
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 5;

        // Example graph represented by adjacency matrix
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        // Print the solution
        primMST(graph, V);
    }
}
