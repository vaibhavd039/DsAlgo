package shortpath;

import base.Graph;
import base.UnWeightedGraph;
import builders.SimpleUnWeightedUnDirectionalGraphBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInDAG {

    static boolean[] visited;
    static int[] dist;
    static int[] parent;

    public static void main(String args[]) {
        UnWeightedGraph graph = new UnWeightedGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,3);
        graph.addEdge(2,4);
        graph.addEdge(4,2);
        graph.addEdge(1,0);
        visited = new boolean[graph.vertex];
        parent = new int[graph.vertex];
        dist = new int[graph.vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        getPath(graph, 0, 4);
        int crawl = 4;
        while(crawl!=-1){
            System.out.print(crawl+"\t");
            crawl=parent[crawl];
        }
    }

    public static void getPath(UnWeightedGraph graph, int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        dist[source] = 0;
        parent[source] = -1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> nextNode = graph.graphNodes.get(curr);
            for (Integer next : nextNode) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    parent[next] = curr;
                    queue.add(next);
                    if (next == destination) {
                        return;
                    }
                }
            }

        }
    }

}
