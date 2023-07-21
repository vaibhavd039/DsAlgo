package cycle;

import base.UnWeightedGraph;

import java.util.Arrays;
import java.util.List;

enum ColorCode {
    WHITE,
    BLACK,
    GREY
}

public class CheckCycleColored {
    static ColorCode[] colors;

    public static void main(String[] args) {
        colors = new ColorCode[9];
        Arrays.fill(colors, ColorCode.WHITE);
        UnWeightedGraph unWeightedGraph = new UnWeightedGraph(9);
        unWeightedGraph.addEdge(0, 1);
        unWeightedGraph.addEdge(0, 2);
        unWeightedGraph.addEdge(1, 4);
        unWeightedGraph.addEdge(2, 5);
        unWeightedGraph.addEdge(4, 5);
        unWeightedGraph.addEdge(5, 6);
        unWeightedGraph.addEdge(4, 8);
        unWeightedGraph.addEdge(6, 7);
        unWeightedGraph.addEdge(7, 8);
        unWeightedGraph.addEdge(5, 0);
        System.out.println(checkForLoop(unWeightedGraph, 0));
    }

    public static boolean checkForLoop(UnWeightedGraph unWeightedGraph, int source) {
        if (colors[source] == ColorCode.BLACK)
            return false;
        colors[source] = ColorCode.GREY;
        List<Integer> nextNodes = unWeightedGraph.graphNodes.get(source);
        for (Integer next : nextNodes) {
            if (colors[next] == ColorCode.WHITE) {
                if (checkForLoop(unWeightedGraph, next)) {
                    return true;
                }
            } else if (colors[next] == ColorCode.GREY) {
                return true;
            }
        }
        colors[source] = ColorCode.BLACK;
        return false;
    }
}
