package base;

import java.util.*;

public class WeightedGraph {
    public int vertex;
    public List<WeighedEdge> graphNodes;

   public WeightedGraph(int vertex) {
        this.vertex = vertex;
        graphNodes = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        this.graphNodes.add(new WeighedEdge(source, destination, weight));
    }
}

