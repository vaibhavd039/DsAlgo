package bsf_dfs;

import base.UnWeightedGraph;

import java.util.*;

public class DirectedGraphBFS {
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        UnWeightedGraph unWeightedGraph = new UnWeightedGraph(6);
        unWeightedGraph.addEdge(0, 1);
        unWeightedGraph.addEdge(0, 2);
        unWeightedGraph.addEdge(2, 0);
        unWeightedGraph.addEdge(1, 2);
        unWeightedGraph.addEdge(2, 3);
        unWeightedGraph.addEdge(3, 3);
        bfs(unWeightedGraph);
    }

    public static void bfs(UnWeightedGraph unWeightedGraph) {
        for (int i = 0; i < unWeightedGraph.vertex; i++) {
            if (!visited.contains(i)) {
                bfsUtil(unWeightedGraph, i);
            }
        }
    }

    public static void bfsUtil(UnWeightedGraph unWeightedGraph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!visited.contains(temp)) {
                System.out.println(temp + "\t");
                visited.add(temp);
            }
            List<Integer> nextNodes = unWeightedGraph.graphNodes.get(temp);
            for (Integer next : nextNodes) {
                if (!visited.contains(next)) {
                    System.out.print(next + "\t");
                    visited.add(next);
                    queue.add(next);
                }

            }
            System.out.println("");
        }
    }
}
