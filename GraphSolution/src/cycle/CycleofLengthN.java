package cycle;

import base.UnWeightedGraph;

import java.util.List;

public class CycleofLengthN {
    static int cycleCount = 0;
    static int cycleLength = 3;

    public static void main(String[] args) {

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
        unWeightedGraph.addEdge(2, 3);
        unWeightedGraph.addEdge(3, 2);
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
        boolean [] visited = new boolean[9];
        for (int i = 0; i < unWeightedGraph.vertex; i++) {
            countCycle(unWeightedGraph, i , i, 5,visited);
            System.out.println("\n");
            visited[i] = true;
        }
        System.out.println(cycleCount/2);
    }


    public static void countCycle(UnWeightedGraph unWeightedGraph, int source, int start, int pathLength, boolean [] visited) {
        visited[source] = true;
        if (pathLength == 0) {
            visited[source] = false;
            if (unWeightedGraph.graphNodes.get(source).contains(start)) {
                cycleCount++;
                return;
            } else {
                return;
            }
        }
        List<Integer> elements = unWeightedGraph.graphNodes.get(source);
        for (Integer next : elements) {
            if (!visited[next]) {
                countCycle(unWeightedGraph, next, start, pathLength - 1, visited);
            }
        }
        visited[source] = false;
    }


}
