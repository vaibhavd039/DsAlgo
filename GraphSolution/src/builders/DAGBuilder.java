package builders;

import base.UnWeightedGraph;

public class DAGBuilder {
    public static UnWeightedGraph buildDAG() {
        UnWeightedGraph unWeightedGraph = new UnWeightedGraph(9);
        unWeightedGraph.addEdge(0, 1);
        unWeightedGraph.addEdge(0, 2);
        unWeightedGraph.addEdge(1, 4);
        unWeightedGraph.addEdge(2, 5);
        unWeightedGraph.addEdge(4, 5);
        unWeightedGraph.addEdge(5, 6);
        unWeightedGraph.addEdge(4, 8);
        unWeightedGraph.addEdge(6, 7);
        unWeightedGraph.addEdge(7, 8);
        return unWeightedGraph;
    }
}
