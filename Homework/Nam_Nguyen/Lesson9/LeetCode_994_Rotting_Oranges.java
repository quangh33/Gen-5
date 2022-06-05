package Homework.Nam_Nguyen.Lesson9;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_994_Rotting_Oranges {

    public static int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        int height = grid.length;
        int width = grid[0].length;
        boolean containFreshOrange = false;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }else if(grid[i][j] == 1) {
                    containFreshOrange = true;
                }
            }
        }

        if(queue.isEmpty()){
            if(containFreshOrange)  return -1;
            return 0;
        }

        int minutes = 0;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while(!queue.isEmpty()) {
             // because whenever I find a rotted orange, I push both x and y into queue (2 values)
            int currentNumbersOfRottedOranges = queue.size()/2;
            for (int i = 0; i < currentNumbersOfRottedOranges; i++) {
                int x = queue.poll();
                int y = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if(newX >= 0 && newX < height && newY >= 0 && newY < width && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.add(newX);
                        queue.add(newY);
                    }
                }
            }
            minutes++;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1}
        };
        System.out.println("res: "+orangesRotting(grid));
    }    
}
