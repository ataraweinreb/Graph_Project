import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void standard(Graph g) {
        System.out.println("A standard BFS topological sort traversal:");
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < g.numVertices(); i++) {
            if (g.indegree[i] == 0) {
                Q.offer(i);
            }
        }
        while(!Q.isEmpty()) {
            int vertex = Q.poll();
            System.out.print(vertex + ", ");
            for (int neighbor : g.adj[vertex]) {
                g.indegree[neighbor]--;
                if (g.indegree[neighbor] == 0) {
                    Q.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
    public static void findCenter(Graph ug) {
        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();
        int numVertices = ug.numVertices();
        for (int i : ug.indegree) {
            if (ug.indegree[i] == 1) {
                Q1.offer(i);
            }
        }
        numVertices -= Q1.size();
        while (numVertices > 0) {
            do {
                int v = Q1.poll();
                for (int neighbor : ug.adj[v]) {
                    ug.indegree[neighbor]--;
                    if (ug.indegree[neighbor] == 1)
                        Q2.offer(neighbor);
                }
            } while(!Q1.isEmpty());
            while (!Q2.isEmpty())
                Q1.offer(Q2.poll());
            numVertices -= Q1.size();
        }
    System.out.print("The center of the undirected graph is: ");
    while (!Q1.isEmpty())
        System.out.print(Q1.poll() + ", ");
    }
}
