package bsf_dfs;

import base.Graph;
import base.GraphBuilder;

import java.util.List;

public class DFSImplementation {
    static boolean[] visited;

    public static void main(String[] args) {
        Graph graph = GraphBuilder.buildSampleGraphUndirected();
        visited = new boolean[graph.vertex];
        DFS(graph, 0);
    }

    public static void DFS(Graph graph, int source) {
        if (graph == null)
            return;
        if (!visited[source]) {
            visited[source] = true;
            System.out.println(source + "\t");
        }
        List<Integer> neighbours = graph.graphNodes.get(source);
        for (Integer num : neighbours) {
            if (!visited[num]) {
                System.out.println(num + "\t");
                visited[num] = true;
                DFS(graph, num);
            }
        }
    }
}
