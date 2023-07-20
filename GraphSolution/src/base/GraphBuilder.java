package base;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder {
    public static Graph buildGraph(int vertex, List<List<Integer>> edges) {
        Graph graph = new Graph(vertex);
        for (List<Integer> entry : edges) {
            graph.addEdge(entry.get(0), entry.get(1));
            graph.addEdge(entry.get(1), entry.get(0));
        }
        return graph;
    }

    public static Graph buildSampleGraphUndirected() {
        int vertex = 5;
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge1 = List.of(0, 1);
        List<Integer> edge2 = List.of(0, 2);
        List<Integer> edge3 = List.of(0, 3);
        List<Integer> edge4 = List.of(0, 4);
        List<Integer> edge5 = List.of(1, 2);
        List<Integer> edge6 = List.of(1, 3);
        List<Integer> edge7 = List.of(3, 2);
        List<Integer> edge8 = List.of(4, 2);
        List<Integer> edge9 = List.of(3, 4);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);
        edges.add(edge8);
        edges.add(edge9);
        return buildGraph(vertex, edges);
    }
}
