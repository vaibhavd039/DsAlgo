package topological;

import base.WeighedEdge;
import base.WeightedGraph;
import builders.WeightedCyclicGraphBuilder;
import builders.WeightedUndirectedGraph;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class TopologicalSort {
    static Stack<Integer> nodes;
    static boolean[] visited;

    public static void main(String[] args) {
        WeightedGraph graph = WeightedUndirectedGraph.buildeWeightedUndirectredGraph();
        nodes = new Stack<>();
        visited = new boolean[graph.vertex];
        Map<Integer, List<WeighedEdge>> graphMap =
                graph.graphNodes.stream().collect(Collectors.groupingBy(element -> element.source));
        topologicalSort(graphMap, 0);
        while (!nodes.isEmpty()) {
            System.out.println(nodes.pop());
        }
    }

    public static void topologicalSort(Map<Integer, List<WeighedEdge>> graph, int source) {
        visited[source] = true;
        nodes.push(source);
        List<WeighedEdge> edges = graph.get(source);
        for (WeighedEdge edge : edges) {
            if (!visited[edge.destination]) {
                visited[edge.destination] = true;
                topologicalSort(graph, edge.destination);
            }
        }
    }
}
