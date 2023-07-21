package bsf_dfs;

import base.UnWeightedGraph;
import builders.SimpleUnWeightedUnDirectionalGraphBuilder;

import java.util.List;

public class DFSImplementation {
    static boolean[] visited;

    public static void main(String[] args) {
        UnWeightedGraph unWeightedGraph = SimpleUnWeightedUnDirectionalGraphBuilder.buildSampleGraphUndirected();
        visited = new boolean[unWeightedGraph.vertex];
        DFS(unWeightedGraph, 0);
    }

    public static void DFS(UnWeightedGraph unWeightedGraph, int source) {
        if (unWeightedGraph == null)
            return;
        if (!visited[source]) {
            visited[source] = true;
            System.out.println(source + "\t");
        }
        List<Integer> neighbours = unWeightedGraph.graphNodes.get(source);
        for (Integer num : neighbours) {
            if (!visited[num]) {
                System.out.println(num + "\t");
                visited[num] = true;
                DFS(unWeightedGraph, num);
            }
        }
    }
}
