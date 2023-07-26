package must;

import java.util.Arrays;

public class CheckBiprate {
    static int V = 4;
    static int[] colored;

    public static void main(String[] args) {

        colored = new int[4];
        Arrays.fill(colored, -1);
        int graph[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};
        for (int i = 0; i < V; i++) {
            if (colored[i] == -1) {
                if(colorGraph(graph, i, 0)){
                    System.out.println("yes");
                }
                else {
                    System.out.println("false");
                }
            }
        }
    }


    public static boolean colorGraph(int[][] graph, int source, int color) {
        colored[source] = color;
        int nextColor = getNextColor(color);
        for (int i = 0; i < V; i++) {
            if (graph[source][i] != 0) {
                if (colored[i] == -1) {
                    colorGraph(graph, i, nextColor);
                } else {
                    if (colored[i] == colored[source]) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static int getNextColor(int color) {
      return color==0?1:0;
    }
}
