package mst;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prims {
    static Set<Integer> included;
    static int[] dist;
    static int[] parent;

    public static void main(String[] args) {
        included = new HashSet<>();
        dist = new int[5];
        parent = new int[5];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int graph[][] = new int[][]
                {{0, 2, 0, 6, 0},
                        {2, 0, 3, 8, 5},
                        {0, 3, 0, 0, 7},
                        {6, 8, 0, 0, 9},
                        {0, 5, 7, 9, 0}};
        printMST(graph, 0);
    }

    public static void printMST(int[][] graph, int source) {
        parent[source] = 0;
        dist[source] = 0;
        for (int i = 0; i < graph.length; i++) {
            int u = findMinKey();
            included.add(u);
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && !included.contains(v) && graph[u][v] < dist[v]) {
                    parent[v] = u;
                    dist[v] = graph[u][v];
                }
            }
        }
        printMSTOutput(parent, graph);

    }

    static void printMSTOutput(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[i][parent[i]]);
    }

    public static int findMinKey() {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!included.contains(i) && dist[i] < min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }
}
