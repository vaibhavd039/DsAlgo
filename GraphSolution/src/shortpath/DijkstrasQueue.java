package shortpath;

import base.WeighedEdge;
import base.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DijkstrasQueue {
    static boolean[] processed;
    static int[] distance;

    static List<Integer> nextNode;

    public static void main(String[] args) {
        processed = new boolean[6];
        distance = new int[6];
        nextNode = new ArrayList<>();
        WeightedGraph graph = new WeightedGraph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(1, 0, 6);
        graph.addEdge(0, 3, 0);
        graph.addEdge(3, 0, 0);
        graph.addEdge(0, 2, 8);
        graph.addEdge(2, 0, 8);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 5, 1);
        graph.addEdge(5, 1, 1);
        graph.addEdge(3, 5, 3);
        graph.addEdge(5, 3, 3);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 4, 1);
        graph.addEdge(4, 3, 2);
        graph.addEdge(3, 4, 1);
        Map<Integer, List<WeighedEdge>> sourceToDesination =
                graph.graphNodes.stream().collect(Collectors.groupingBy(element -> element.source));
    }

    public static void generatePath(Map<Integer, List<WeighedEdge>> sourceToDesination, int source) {
        nextNode.add(source);
        PriorityQueue<WeighedEdge> queue = new PriorityQueue<>();
        queue.addAll(sourceToDesination.get(source));
        while (!queue.isEmpty()) {
            WeighedEdge edge = queue.poll();
            if(edge.weight>distance[edge.destination]){
                continue;
            }

        }
    }
}
