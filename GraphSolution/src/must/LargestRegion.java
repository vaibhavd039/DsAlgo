package must;

public class LargestRegion {
    static int ROW, COL;
    static boolean[][] visited;

    public static void main(String[] args) {
        int M[][] =
                {{0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}};
        ROW = 4;
        COL = 5;
        visited = new boolean[ROW][COL];
        printLargestRegion(M);
    }

    public static void printLargestRegion(int[][] graph) {
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    int size = dfs(graph, i, j, 0);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        System.out.println(maxSize);
    }

    public static int dfs(int[][] graph, int row, int col, int size) {
        visited[row][col] = true;
        int[] validRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] validCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; i++) {
            if (isSafe(graph, row + validRow[i], col + validCol[i])) {
                size++;
                size = dfs(graph, row + validRow[i], col + validCol[i], size);
            }
        }
        return size;
    }

    public static boolean isSafe(int[][] graph, int row, int col) {
        return (row < ROW) && (row >= 0) && (col < COL) && (col >= 0) && (graph[row][col] != 0) && !visited[row][col];
    }
}
