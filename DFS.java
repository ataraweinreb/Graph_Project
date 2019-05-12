public class DFS {
    public static void standard(Graph g) {
        System.out.println("A standard DFS traversal:");
        boolean[] visted = new boolean[g.numVertices()]; //set to false
        for (int i = 0; i < visted.length; i++) {
            if (!visted[i]) {
                standard(i, visted, g);
            }
        }
        System.out.println();
    }
    private static void standard(int i, boolean visited[], Graph g) {
        visited[i] = true;
        System.out.print(i + ", ");
        for (int neighbor : g.adj[i]) {
            if (!visited[neighbor]) {
                standard(neighbor, visited, g);
            }
        }
    }
    public static void topsort(Graph g) {
        System.out.println("Tarjan's DFS-based reverse topological sort:");
        boolean started[] = new boolean[g.numVertices()];
        boolean finished[] = new boolean[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++) {
            if (!started[i])
                topsort(i, started, finished, g);
        }
        System.out.println();
    }
    private static void topsort(int i, boolean[] started, boolean[] finished, Graph g) {
        started[i] = true;
        for (int neighbor : g.adj[i]) {
            if (!started[neighbor]) {
                topsort(neighbor, started, finished, g);
            }
            else if (!finished[neighbor]) {
                try {
                    throw new Exception("Cycle detected in graph.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.print(i + ", ");
        finished[i] = true;
    }
}
