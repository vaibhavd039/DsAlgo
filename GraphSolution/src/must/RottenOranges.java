package must;

import java.util.LinkedList;
import java.util.Queue;

class Element {
    int row, col;

    Element(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class RottenOranges {
    static int time = 0;
    static int ROW, COL;
    static int[] validRow = {0, 0, -1, 1};
    static int[] validCol = {-1, 1, 0, 0};

    public static void main(String[] args) {
        int[][] graph = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        ROW = 3;
        COL = 5;
        countMinTimeToRott(graph);
        System.out.println(time);
    }

    public static void countMinTimeToRott(int[][] graph) {
        Queue<Element> queue = new LinkedList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (graph[i][j] == 2) {
                    queue.add(new Element(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                Element temp = queue.poll();
                //rott to next element
                for (int k = 0; k < 4; k++) {
                    if (isSafe(graph, temp.row + validRow[k], temp.col + validCol[k])) {
                        graph[temp.row + validRow[k]][temp.col + validCol[k]] = 2;
                        queue.add(new Element(temp.row + validRow[k], temp.col + validCol[k]));
                    }
                }

            }
            time++;
            if (checkifAllRotten(graph)) {
                return;
            }
        }
    }

    public static boolean checkifAllRotten(int[][] graph) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (graph[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(int[][] graph, int row, int col) {
        return (row >= 0 && row < ROW && col < COL && col >= 0) && graph[row][col] == 1;
    }

}
