package shortpath;

import base.WeightedGraph;

public class MinCycleInWeightedGraph {
    static boolean [] visited ;
    static int [] distance ;
    public static void main(String [] args){
        visited = new boolean[6];
        distance = new int[6];
        WeightedGraph graph = new WeightedGraph(6);
        graph.addEdge(0,1,6);
        graph.addEdge(1,0,6);
        graph.addEdge(0,3,0);
        graph.addEdge(3,0,0);
        graph.addEdge(0,2,8);
        graph.addEdge(2,0,8);
        graph.addEdge(1,2,2);
        graph.addEdge(2,1,2);
        graph.addEdge(1,5,1);
        graph.addEdge(5,1,1);
        graph.addEdge(3,5,3);
        graph.addEdge(5,3,3);
        graph.addEdge(4,5,1);
        graph.addEdge(5,4,1);
        graph.addEdge(4,3,2);
        graph.addEdge(3,4,1);

    }


}
