package shortpath;

import base.WeighedEdge;
import base.WeightedGraph;
import builders.WeightedCyclicGraphBuilder;

import java.util.Arrays;

public class BellManFord {
    static int[] dist;

    public static void main(String[] args) {
        WeightedGraph graph = WeightedCyclicGraphBuilder.buildGraphWithNegativeEdge();
        dist = new int[graph.vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int count = 0; count < graph.vertex - 1; count++) {
            releaseEdges(graph);
            System.out.println("");
        }
        for(int i =0;i< dist.length;i++){
            System.out.println(dist[i]);
        }
    }

    public static void releaseEdges(WeightedGraph graph) {
        for (WeighedEdge edge : graph.graphNodes) {
           int u =  edge.source;
            int v =   edge.destination;
            int w =  edge.weight;
            if(dist[v]>dist[u]+w){
                dist[v]=dist[u]+w;
            }
        }
    }
}
