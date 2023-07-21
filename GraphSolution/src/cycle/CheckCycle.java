package cycle;

import base.UnWeightedGraph;

import java.util.List;

public class CheckCycle {
    static boolean[] visited;
    static boolean[] currStack;

    public static void main(String[] args) {
        UnWeightedGraph unWeightedGraph = new UnWeightedGraph(9);
        visited = new boolean[9];
        currStack = new boolean[9];
        unWeightedGraph.addEdge(0, 1);
        unWeightedGraph.addEdge(0, 2);
        unWeightedGraph.addEdge(1, 4);
        unWeightedGraph.addEdge(2, 5);
        unWeightedGraph.addEdge(4, 5);
        unWeightedGraph.addEdge(5, 6);
        unWeightedGraph.addEdge(4, 8);
        unWeightedGraph.addEdge(6, 7);
        unWeightedGraph.addEdge(7, 8);
        unWeightedGraph.addEdge(5, 0);
        System.out.println(checkCycle(unWeightedGraph, 0));
    }

    public static boolean checkCycle(UnWeightedGraph unWeightedGraph, int source) {
        if (currStack[source])
            return true;
        if (visited[source])
            return false;
        visited[source] = true;
        currStack[source] = true;
        List<Integer> nextNodes = unWeightedGraph.graphNodes.get(source);
        for (Integer next : nextNodes) {
            if (checkCycle(unWeightedGraph, next)) {
                return true;
            }
        }
        currStack[source] = false;
        return false;
    }

}
