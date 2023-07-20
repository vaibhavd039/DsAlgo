package bsf_dfs;

import base.Graph;
import base.GraphBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSImplementaion {
    public static void main(String[] args) {
        Graph graph = GraphBuilder.buildSampleGraphUndirected();
        bfsTraversal(graph, 1);
    }

    public static void bfsTraversal(Graph graph, int source) {
        if (graph == null || graph.vertex == 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertex];
        queue.add(source);
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            List<Integer> neighbours = graph.graphNodes.get(temp);
            if (!visited[temp]) {
                System.out.print(temp);
                visited[temp] = true;
                System.out.print("\n");
            }
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    System.out.print(neighbour + "\t");
                    queue.add(neighbour);
                }
            }
            System.out.print("\n");
        }
    }
}
