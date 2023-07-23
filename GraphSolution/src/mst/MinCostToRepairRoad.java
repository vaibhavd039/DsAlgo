package mst;

import java.util.Arrays;

public class MinCostToRepairRoad {
    static int V;
    static int[] parent;
    static boolean[] included;
    static int[] dist;

    public static void main(String[] args) {

        int v = 5;
        V = v;
        dist = new int[v];
        parent = new int[v];
        included = new boolean[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(included, false);

        int[][] graph = {{0, 1, 2, 3, 4},
                {1, 0, 5, 0, 7},
                {2, 5, 0, 6, 0},
                {3, 0, 6, 0, 0},
                {4, 7, 0, 0, 0}};
        minmumCost(graph, v, 0);

    }

    public static void minmumCost(int[][] graph, int v, int source) {
        dist[source] = 0;
        parent[source] = -1;
        for (int i = 0; i < v; i++) {
            int u = minKey();
            included[u] = true;
            for (int dest = 0; dest < v; dest++) {
                if (graph[u][dest] != 0 && !included[dest] && graph[u][dest] < dist[dest]) {
                    dist[dest] = graph[u][dest];
                    included[dest] = true;
                }
            }
        }
        int minCost = 0;
        for (int x = 0; x < v; x++) {
            minCost += dist[x];
        }
        System.out.println(minCost);
    }

    public static int minKey() {
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i = 0; i < V; i++) {
            if (!included[i] && dist[i] < min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }
}
