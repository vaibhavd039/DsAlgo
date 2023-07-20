package bsf_dfs;

import base.Graph;

import java.util.*;

public class DirectedGraphBFS {
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        bfs(graph);
    }

    public static void bfs(Graph graph) {
        for (int i = 0; i < graph.vertex; i++) {
            if (!visited.contains(i)) {
                bfsUtil(graph, i);
            }
        }
    }

    public static void bfsUtil(Graph graph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!visited.contains(temp)) {
                System.out.println(temp + "\t");
                visited.add(temp);
            }
            List<Integer> nextNodes = graph.graphNodes.get(temp);
            for (Integer next : nextNodes) {
                if (!visited.contains(next)) {
                    System.out.print(next + "\t");
                    visited.add(next);
                    queue.add(next);
                }

            }
            System.out.println("");
        }
    }
}
