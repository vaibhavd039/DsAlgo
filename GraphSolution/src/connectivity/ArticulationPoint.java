package connectivity;

import base.Graph;

public class ArticulationPoint {
    static int timer = 0;
    static int[] parent;
    static int[] disc;
    static int[] low;
    static boolean[] visited;


    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdges(0, 1, 1);
        graph.addEdges(1, 0, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(2, 0, 1);
        graph.addEdges(1, 2, 1);
        graph.addEdges(2, 1, 1);
        graph.addEdges(0, 3, 1);
        graph.addEdges(3, 0, 1);

        graph.addEdges(3, 4, 1);
        graph.addEdges(4, 3, 1);

        graph.addEdges(4, 5, 1);
        graph.addEdges(5, 4, 1);
        graph.addEdges(4, 6, 1);
        graph.addEdges(6, 4, 1);

        graph.addEdges(5, 6, 1);
        graph.addEdges(6, 5, 1);
        disc = new int[7];
        parent = new int[7];
        low = new int[7];
        visited = new boolean[7];
        for (int i = 0; i < graph.vertex; i++) {
            if (!visited[i]) {
                printArticulationPoint(graph, i);
            }
        }
    }

    public static void printArticulationPoint(Graph graph, int source) {
        int children = 0;
        timer++;
        disc[source] = timer;
        low[source] = timer;
        visited[source] = true;
        for (int i = 0; i < graph.vertex; i++) {
            if (graph.edges[source][i] != 0) {
                if (!visited[i]) {
                    children++;
                    parent[i] = source;
                    printArticulationPoint(graph, i);
                    low[source] = Math.min(low[source], low[i]);
                    if (parent[i] != -1 && low[i] > disc[source]) {
                        System.out.println(i);
                    }
                } else if (low[i] < disc[source]) {
                    low[source] = Math.min(low[source], low[i]);
                }
            }
        }
        if (parent[source] == -1 && children > 1) {
            System.out.println(source);
        }
    }
}
