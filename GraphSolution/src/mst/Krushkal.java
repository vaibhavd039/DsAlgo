package mst;

import base.WeighedEdge;
import base.WeightedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Subset {
    int parent;
    int rank;

    Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

}

public class Krushkal {
    static List<Subset> subset;
    static List<WeighedEdge> edges;

    public static void main(String[] args) {
        edges = new ArrayList<>();
        subset = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            subset.add(new Subset(i, 0));
        }
        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        kruskal(graph);
    }

    public static void kruskal(WeightedGraph graph) {
        Collections.sort(graph.graphNodes);
        int edgeCounter = 0;
        int counter = 0;
        while (edgeCounter < graph.vertex - 1 && counter<graph.graphNodes.size()) {
            WeighedEdge edge = graph.graphNodes.get(counter);
            int rootSource = findRoot(edge.source);
            int rootDestination = findRoot(edge.destination);
            if (rootSource != rootDestination) {
                union(rootSource, rootDestination);
                edges.add(edge);
                edgeCounter++;
            }
            counter++;
        }
        int minCost = 0;

        for (int i = 0; i < edges.size(); i++) {
            System.out.println("Source: " + edges.get(i).source + " destination: " + edges.get(i).destination+" weight" +
                    ": " + edges.get(i).weight);
            minCost+= edges.get(i).weight;
        }
        System.out.println(minCost);
    }

    public static int findRoot(int i) {
        if (subset.get(i).parent == i) {
            return i;
        }
        subset.get(i).parent = findRoot(subset.get(i).parent);
        return subset.get(i).parent;
    }

    public static void union(int x, int y) {
        int rootX = findRoot(x);
        int rooty = findRoot(y);
        if (subset.get(rootX).rank < subset.get(rooty).rank) {
            subset.get(rootX).parent = rooty;
        } else if (subset.get(rootX).rank > subset.get(rooty).rank) {
            subset.get(rooty).parent = rootX;
        } else {
            subset.get(rooty).parent = rootX;
            subset.get(rootX).rank++;
        }
    }
}
