package cycle;

import base.UnWeightedGraph;

import java.util.List;

public class CheckCycleUnDirected {
    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[4];
        UnWeightedGraph unWeightedGraph = new UnWeightedGraph(4);
        unWeightedGraph.addEdge(0, 1);
        unWeightedGraph.addEdge(1, 0);

        unWeightedGraph.addEdge(1, 2);
        unWeightedGraph.addEdge(2, 1);

        unWeightedGraph.addEdge(3, 2);
        unWeightedGraph.addEdge(2, 3);

        unWeightedGraph.addEdge(3, 0);
        unWeightedGraph.addEdge(0, 3);
        System.out.println(checkForCycle(unWeightedGraph, 0, -1));
    }

    public static boolean checkForCycle(UnWeightedGraph unWeightedGraph, int source, int parent) {
        visited[source] = true;
        List<Integer> nextNodes = unWeightedGraph.graphNodes.get(source);
        for (Integer next : nextNodes) {
            if (visited[next] && parent != next) {
                return true;
            } else if (!visited[next]) {
                if (checkForCycle(unWeightedGraph, next, source)) {
                    return true;
                }
            }
        }
        return false;
    }


}
