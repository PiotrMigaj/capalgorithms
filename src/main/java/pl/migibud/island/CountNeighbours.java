package pl.migibud.island;

import java.util.ArrayList;
import java.util.List;

class CountNeighbours {

    static final int ROW = 2, COL = 2;
    static final List<int[]> listOfIndexes = new ArrayList<>();

    boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        return row >= 0
                && row < ROW
                && col >= 0
                && col < COL
                && M[row][col] == 1
                && !visited[row][col];
    }

    void DFS(int[][] M, int row, int col, boolean[][] visited) {
        int[] rowNumber = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNumber = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
        listOfIndexes.add(new int[]{row, col});
        for (int k = 0; k < 8; k++) {
            if (isSafe(M, row + rowNumber[k], col + colNumber[k], visited)) {
                DFS(M, row + rowNumber[k], col + colNumber[k], visited);
            }
        }
    }

    void countIsland(int[][] M, int rowIndex, int colIndex) {
        boolean[][] visited = new boolean[ROW][COL];
        if (M[rowIndex][colIndex] == 1) {
            DFS(M, rowIndex, colIndex, visited);
        }
    }


}
