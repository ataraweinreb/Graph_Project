import java.util.ArrayList;

public class Graph {
    private int vertices;
    private int edges;
    public ArrayList<Integer>[] adj; 
    public int[] indegree;;

    public Graph(int v) {
        if (v < 0)
            throw new IllegalArgumentException("The number of vertices cannot be negative.");
        vertices = v;
        edges = 0; //default
        adj = (ArrayList<Integer>[]) new ArrayList[v];
        for (int i = 0; i < vertices; i++) { 
            adj[i] = new ArrayList<>(); 
        }
        indegree = new int[v];
    }
    public void addDirectedEdge(int vertex1, int vertex2) {
        checkVertex(vertex1);
        checkVertex(vertex2);
        this.edges++;
        adj[vertex1].add(vertex2);
        indegree[vertex2]++;
    }
    public void addUndirectedEdge(int vertex1, int vertex2) {
        checkVertex(vertex1);
        checkVertex(vertex2);
        this.edges++;
        adj[vertex1].add(vertex2);
        adj[vertex2].add(vertex1);
        indegree[vertex1]++;
        indegree[vertex2]++;
    }
    public Iterable<Integer> neighbors(int vertex) {
        checkVertex(vertex);
        return adj[vertex];
    }
    private void checkVertex(int vertex) {
        if (vertex < 0 || vertex > vertices)
            throw new IllegalArgumentException("Vertex is out of range.");
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This graph has " + vertices + " vertices and " + edges + " edges.\n");
        for (int v = 0; v < vertices; v++) {
            sb.append("Vertex " + v + ": ");
            for (int n : adj[v])
                sb.append(n + " ");
            sb.append("\n");
        }
        return sb.toString();
    }
    public int numVertices() {
        return vertices;
    }
    public int numEdges() {
        return edges;
    }
}
