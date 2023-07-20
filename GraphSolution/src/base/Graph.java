package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph {
    public int vertex;
    public Map<Integer, List<Integer>> graphNodes;

    public Graph(int nodes) {
        this.vertex = nodes;
        graphNodes = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            graphNodes.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        graphNodes.get(source).add(destination);
    }
}
