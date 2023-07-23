package connectivity;

import base.Graph;

import java.util.Arrays;

public class Bridge {
    static boolean[] visited;
    static int[] low;
    static int[] diss;

    static int[] parent;
    static int timer = 0;

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
        diss = new int[7];
        parent = new int[7];
        low = new int[7];
        visited = new boolean[7];
        Arrays.fill(diss, -1);
        Arrays.fill(visited, false);
        for (int i = 0; i < graph.vertex; i++) {
            if (!visited[i]) {
                parent[i] = -1;
                printBridge(graph, i);
            }
        }
    }

    public static void printBridge(Graph graph, int source) {
        ++timer;
        diss[source] = timer;
        low[source] = timer;
        visited[source] = true;
        for (int i = 0; i < graph.vertex; i++) {
            if (graph.edges[source][i] != 0) {
                if (!visited[i]) {
                    parent[i] = source;
                    printBridge(graph, i);
                    low[source] = Math.min(low[source], low[i]);
                    if (low[i] > diss[source]) {
                        System.out.println(source + " " + i);
                    }
                }
                else if (i != parent[source]) {
                    low[source] = Math.min(low[source], diss[i]);
                }
            }
        }
    }
}
