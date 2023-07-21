package bsf_dfs;

import base.UnWeightedGraph;
import builders.SimpleUnWeightedUnDirectionalGraphBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSImplementaion {
    public static void main(String[] args) {
        UnWeightedGraph unWeightedGraph = SimpleUnWeightedUnDirectionalGraphBuilder.buildSampleGraphUndirected();
        bfsTraversal(unWeightedGraph, 1);
    }

    public static void bfsTraversal(UnWeightedGraph unWeightedGraph, int source) {
        if (unWeightedGraph == null || unWeightedGraph.vertex == 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[unWeightedGraph.vertex];
        queue.add(source);
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            List<Integer> neighbours = unWeightedGraph.graphNodes.get(temp);
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
