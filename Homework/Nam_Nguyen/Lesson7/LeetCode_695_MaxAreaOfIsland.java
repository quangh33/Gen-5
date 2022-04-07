package Homework.Nam_Nguyen.Lesson7;

public class LeetCode_695_MaxAreaOfIsland {

    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    boolean[][] visited;
    int numberOfRows;
    int numberOfColumns;
    int area = 0;

    private void DFS(int row, int column, int[][] grid) {
        visited[row][column] = true;
        for (int k = 0; k < 4; k++) {
            int xOfNeighborCell = row + dx[k];
            int yOfNeighborCell = column + dy[k];
            if (xOfNeighborCell >= 0 && xOfNeighborCell < numberOfRows 
            && yOfNeighborCell >= 0 && yOfNeighborCell < numberOfColumns 
            && grid[xOfNeighborCell][yOfNeighborCell] != 0 && !visited[xOfNeighborCell][yOfNeighborCell]) {
                area++;
                DFS(xOfNeighborCell, yOfNeighborCell, grid);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        numberOfRows = grid.length;
        numberOfColumns = grid[0].length;
        int numberOfIslands = 0;
        visited = new boolean[numberOfRows][numberOfColumns];
        int maxArea = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    area++;
                    DFS(i, j, grid);
                    if(area > maxArea)  maxArea = area;
                    area=0;
                }
            }
        }
        return numberOfIslands;
    }

    public static void main(String[] args) {
        LeetCode_695_MaxAreaOfIsland lAreaOfIsland = new LeetCode_695_MaxAreaOfIsland();
        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };
        int maxAreaOfIsland = lAreaOfIsland.maxAreaOfIsland(grid);
    }
}
