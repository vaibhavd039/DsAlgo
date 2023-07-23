package must;

public class Island {
    static int isLandCounter = 0;
    static boolean visited[][];
    static int ROW, COL;

    public static void main(String[] args) {
        ROW = COL = 5;
        int graph[][] = new int[][]
                {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        visited = new boolean[ROW][COL];
        findIsland(graph);
        System.out.println(isLandCounter);

    }

    public static void findIsland(int[][] graph) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < ROW; j++) {
                if (graph[i][j] != 0 && visited[i][j] == false) {
                    dfs(graph, i, j);
                    isLandCounter++;
                }
            }
        }
    }

    public static void dfs(int[][] graph, int row, int col) {
        visited[row][col] = true;
        int[] validRow = {-1, -1, -1, 1, 1, 1, 0, 0};
        int[] validCol = {-1, 0, 1, -1, 0, 1, -1, 1};
        for (int k = 0; k < 8; k++) {
            if (isSafe(graph, row + validRow[k], col + validCol[k])) {
                dfs(graph, row + validRow[k], col + validCol[k]);
            }
        }
    }

    public static boolean isSafe(int[][] graph, int row, int col) {
        if (row < ROW && row >= 0 && col < COL && col >= 0) {
            return graph[row][col] == 1 && !visited[row][col];
        } else {
            return false;
        }
    }
}
