package topological;

import base.UnWeightedGraph;

import java.util.*;
import java.util.stream.Collectors;

public class KahnAlgo {
    static int[] inDegree;
    static boolean[] visited;
    static List<Integer> actual;

    public static void main(String[] args) {
        actual = new ArrayList<>();
        inDegree = new int[6];
        visited = new boolean[6];
        Arrays.fill(inDegree, 0);
        UnWeightedGraph graph = new UnWeightedGraph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        computeIndegree(graph);
        kahn(graph);
        actual.forEach(e->System.out.print(e+"\t"));
    }

    public static void computeIndegree(UnWeightedGraph graph) {
        List<Integer> edges = graph.graphNodes.values().stream().flatMap(List::stream).collect(Collectors.toList());
        for (Integer dest : edges) {
            inDegree[dest] += 1;
        }
    }

    public static Integer findZeroDegreeNode() {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && !visited[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void kahn(UnWeightedGraph graph) {
        int source = findZeroDegreeNode();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            actual.add(temp);
            List<Integer> nextNodes = graph.graphNodes.get(temp);
            for (Integer next : nextNodes) {
                inDegree[next] -= 1;
            }
            int zero = findZeroDegreeNode();
            if (zero != -1) {
                queue.add(zero);
            }
        }
    }

}
