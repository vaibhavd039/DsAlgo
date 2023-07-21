package shortpath;

import base.Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//How to find Shortest Paths from Source to all Vertices using Dijkstra’s Algorithm

public class Dijkstra {
    static Set<Integer> processed;
    static int[] dist;

    public static void main(String[] args) {
        processed = new HashSet<>();
        Graph graph = new Graph();
        dist = new int[9];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph.vertex = 9;
        graph.edges = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dist[0] = 0; findShortestPath(graph); for (int i = 0; i < graph.vertex; i++) {
            System.out.println(dist[i]);
        }
    }

    public static void findShortestPath(Graph graph) {
        for (int counter = 0; counter < graph.vertex - 1; counter++) {
            int source = findNextMin();
            processed.add(source);
            for (int next = 0; next < graph.vertex; next++) {
                if (!processed.contains(next) && dist[source] != Integer.MAX_VALUE
                        && graph.edges[source][next] != 0
                        && dist[next] > graph.edges[source][next] + dist[source]) {
                    dist[next] = graph.edges[source][next] + dist[source];
                }
            }
        }
    }

    public static int findNextMin() {
        int min = Integer.MAX_VALUE; int min_index = -1; for (int i = 0; i < dist.length; i++) {
            if (!processed.contains(i) && dist[i] < min) {
                min_index = i;
                min = dist[i];
            }
        } return min_index;
    }

}
