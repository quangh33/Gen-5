package Homework.Nam_Nguyen.Lesson7;

public class LeetCode_200_NumberOfIslands {

    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    boolean[][] visited;
    int numberOfRows;
    int numberOfColumns;

    private void DFS(int row, int column, char[][] grid) {
        visited[row][column] = true;
        for (int k = 0; k < 4; k++) {
            int xOfNeighborCell = row + dx[k];
            int yOfNeighborCell = column + dy[k];
            if (xOfNeighborCell >= 0 && xOfNeighborCell < numberOfRows 
            && yOfNeighborCell >= 0 && yOfNeighborCell < numberOfColumns 
            && grid[xOfNeighborCell][yOfNeighborCell] > '0' && !visited[xOfNeighborCell][yOfNeighborCell]) {
                DFS(xOfNeighborCell, yOfNeighborCell, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        numberOfRows = grid.length;
        numberOfColumns = grid[0].length;
        int numberOfIslands = 0;
        visited = new boolean[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (grid[i][j] > '0' && !visited[i][j]) {
                    DFS(i, j, grid);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    public static void main(String[] args) {
        LeetCode_200_NumberOfIslands lAreaOfIsland = new LeetCode_200_NumberOfIslands();
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','0','1','1'},
            {'0','0','0','1','1'}
        };
        int numberOfIslands = lAreaOfIsland.numIslands(grid);
        System.out.println("numberOfIslands: "+numberOfIslands);
    }
}
