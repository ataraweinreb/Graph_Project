public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(3);
        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(1, 2);

        Graph ug = new Graph(3);
        ug.addUndirectedEdge(0, 1);
        ug.addUndirectedEdge(0, 2);

        System.out.println(g);

        DFS.standard(g);
        DFS.topsort(g);
        BFS.standard(g);
        BFS.findCenter(ug);
    }
}

