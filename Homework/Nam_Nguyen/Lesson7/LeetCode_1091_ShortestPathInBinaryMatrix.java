package Homework.Nam_Nguyen.Lesson7;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_1091_ShortestPathInBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
        Queue<Integer> queue = new LinkedList<>();
        int height= grid.length;
        int width = grid[0].length;
        int[][] distances = new int[height][width];
        queue.add(0);
        queue.add(0);

        while(!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            if(x == height - 1 && y == width - 1)   return distances[height - 1][width - 1] + 1;
            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >= 0 && newX < height && newY >= 0 && newY < width && grid[newX][newY] == 0) {
                    distances[newX][newY] = distances[x][y] + 1;
                    queue.add(newX);
                    queue.add(newY);
                    grid[newX][newY] = 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
            {1,0,0},
            {1,1,0},
            {1,1,0}
        };
        System.out.println("res: " + shortestPathBinaryMatrix(grid));
    }
}
