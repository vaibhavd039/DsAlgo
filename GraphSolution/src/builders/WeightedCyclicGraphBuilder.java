package builders;

import base.WeightedGraph;

public class WeightedCyclicGraphBuilder {
    public static WeightedGraph buildGraphWithNegativeEdge(){
        WeightedGraph graph= new WeightedGraph(9);
        graph.addEdge(0, 1,1);
        graph.addEdge(0, 2,-1);
        graph.addEdge(1, 4,3);
        graph.addEdge(2, 5,-4);
        graph.addEdge(4, 5,-1);
        graph.addEdge(5, 6,5);
        graph.addEdge(4, 8,1);
        graph.addEdge(6, 7,6);
        graph.addEdge(7, 8,6);
        graph.addEdge(5, 0,-20);
        return graph;
    }

}
