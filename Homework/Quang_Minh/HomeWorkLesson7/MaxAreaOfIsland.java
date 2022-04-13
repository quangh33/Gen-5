package HomeWorkLesson7;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {
    int[][] visited;
    static final int[][] step = {{1,0}, {-1,0}, {0,1} , {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    maxArea = Math.max(maxArea, BFS(i, j, grid));
                }
            }
        }
        return maxArea;
    }
    private boolean validStep(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
    int BFS(int i, int j, int[][] grid){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = 1;
        int currentArea = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            currentArea++;
            for (int[] d : step) {
                int x = current[0] + d[0];
                int y = current[1] + d[1];
                if (validStep(x, y, grid) && visited[x][y] == 0) {
                    visited[x][y] = 1;
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return currentArea;
    }


}
