package bsf_dfs;

import base.UnWeightedGraph;

import java.util.List;

public class DFS_Revise {
    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[9];
        UnWeightedGraph unWeightedGraph = new UnWeightedGraph(9);
        unWeightedGraph.addEdge(0, 1);
        unWeightedGraph.addEdge(1, 0);
        unWeightedGraph.addEdge(0, 2);
        unWeightedGraph.addEdge(2, 0);
        unWeightedGraph.addEdge(0, 3);
        unWeightedGraph.addEdge(3, 0);

        unWeightedGraph.addEdge(1, 2);
        unWeightedGraph.addEdge(2, 1);
        unWeightedGraph.addEdge(1, 4);
        unWeightedGraph.addEdge(4, 1);

        unWeightedGraph.addEdge(2, 5);
        unWeightedGraph.addEdge(5, 2);

        unWeightedGraph.addEdge(4, 5);
        unWeightedGraph.addEdge(5, 4);

        unWeightedGraph.addEdge(4, 8);
        unWeightedGraph.addEdge(8, 4);

        unWeightedGraph.addEdge(3, 5);
        unWeightedGraph.addEdge(5, 3);
        unWeightedGraph.addEdge(3, 6);
        unWeightedGraph.addEdge(6, 3);
        unWeightedGraph.addEdge(3, 7);
        unWeightedGraph.addEdge(7, 3);

        unWeightedGraph.addEdge(6, 5);
        unWeightedGraph.addEdge(5, 6);
        printDFS(unWeightedGraph, 0);
    }

    public static void printDFS(UnWeightedGraph unWeightedGraph, int source) {
        if (!visited[source]) {
            System.out.println(source + "\t");
            visited[source] = true;
        }
        List<Integer> nextNodes = unWeightedGraph.graphNodes.get(source);
        for (Integer next : nextNodes) {
            if (!visited[next]) {
                printDFS(unWeightedGraph, next);
            }
        }
    }
}
