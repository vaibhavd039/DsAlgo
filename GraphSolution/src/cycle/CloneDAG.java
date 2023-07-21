package cycle;

import base.UnWeightedGraph;
import builders.DAGBuilder;

import java.util.List;

public class CloneDAG {
    static boolean[] visisted;

    public static void main(String[] args) {

        UnWeightedGraph graph = DAGBuilder.buildDAG();
        UnWeightedGraph newGraph = new UnWeightedGraph(graph.vertex);
        visisted = new boolean[graph.vertex];
        dfs(graph, 0);
        visisted = new boolean[graph.vertex];
        System.out.println("breaking");
        for (int i = 0; i < graph.vertex; i++) {
            if (!visisted[i]) {
                cloneDAG(graph, newGraph, i);
            }
        }
        visisted = new boolean[graph.vertex];
        dfs(newGraph, 0);
    }

    public static void cloneDAG(UnWeightedGraph graph, UnWeightedGraph newGraph, int source) {
        if (visisted[source]) {
            return;
        }
        visisted[source] = true;
        List<Integer> nextNodes = graph.graphNodes.get(source);
        newGraph.graphNodes.get(source).addAll(nextNodes);
        for (Integer next : nextNodes) {
            if (!visisted[next]) {
                cloneDAG(graph, newGraph, next);
            }
        }
    }

    public static void dfs(UnWeightedGraph node, int source) {
        if (!visisted[source]) {
            System.out.println(source);
            visisted[source] = true;
        } else {
            return;
        }
        List<Integer> nextNodes = node.graphNodes.get(source);
        for (Integer next : nextNodes) {
            if (!visisted[next]) {
                dfs(node, next);
            }
        }
    }
}
