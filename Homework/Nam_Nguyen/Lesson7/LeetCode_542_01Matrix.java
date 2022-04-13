package Homework.Nam_Nguyen.Lesson7;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_542_01Matrix {

    public static int[][] updateMatrix(int[][] mat) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Integer> queue = new LinkedList<>();
        int height= mat.length;
        int width= mat[0].length;
        int[][] distances = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(mat[i][j] == 0) {
                    distances[i][j] = 0;
                    queue.add(i);
                    queue.add(j);
                } else {
                    distances[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >= 0 && newX < height && newY >= 0 && newY < width && distances[newX][newY] == -1) {
                    distances[newX][newY] = distances[x][y] + 1;
                    queue.add(newX);
                    queue.add(newY);
                }
            }
        }
        return distances;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
            {1,0,0},
            {1,1,0},
            {1,1,0}
        };
        int[][] res = updateMatrix(grid);

        for (int[] is : res) {
            for (int is2 : is) {
                System.out.print(" "+is2);
            }
            System.out.println();
        }
    }
}
