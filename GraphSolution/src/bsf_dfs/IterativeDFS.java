package bsf_dfs;

import base.Graph;
import base.GraphBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class IterativeDFS {
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Graph graph = GraphBuilder.buildSampleGraphUndirected();
        dfs(graph, 2);
    }

    public static void dfs(Graph graph, int source) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            if (!visited.contains(temp)) {
                System.out.println(temp);
                visited.add(temp);
            }
            List<Integer> next = graph.graphNodes.get(temp);
            for (Integer element : next) {
                if (!visited.contains(element)) {
                    System.out.println(element);
                    visited.add(element);
                    stack.add(element);
                }
            }
        }
    }
}
