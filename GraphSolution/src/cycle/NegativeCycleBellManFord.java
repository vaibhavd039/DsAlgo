package cycle;

import base.WeighedEdge;
import base.WeightedGraph;
import builders.WeightedCyclicGraphBuilder;

import java.util.Arrays;
import java.util.List;

public class NegativeCycleBellManFord {
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) {
        WeightedGraph graph = WeightedCyclicGraphBuilder.buildGraphWithNegativeEdge();
        dist = new int[graph.vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        for (int i = 0; i < graph.vertex - 1; i++) {
            relaxEdges(graph);
            System.out.println("this");
        }
        System.out.println(checkCycle(graph));

    }

    public static boolean checkCycle(WeightedGraph graph){
        List<WeighedEdge> edges = graph.graphNodes;
        for (WeighedEdge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;
            if (dist[v] > dist[u] + w) {
               return true;
            }
        }
        return false;
    }

    public static void relaxEdges(WeightedGraph graph) {
        List<WeighedEdge> edges = graph.graphNodes;
        for (WeighedEdge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;
            if (dist[v] > dist[u] + w) {
                dist[v] = dist[u] + w;
            }
        }
    }

}
