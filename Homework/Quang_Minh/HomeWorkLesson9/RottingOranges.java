package HomeWorkLesson9;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int result = 0;
        int height = grid.length;
        int width = grid[0].length;
        int[] stepX = {0, -1, 1, 0};
        int[] stepY = {-1, 0, 0, 1};
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 2) queue.add(new Position(i, j));
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position currentPosition = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = currentPosition.x + stepX[j];
                    int nextY = currentPosition.y + stepY[j];
                    if (nextX >= 0 && nextY >= 0 && nextX < height && nextY < width && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        queue.add(new Position(nextX, nextY));
                    }
                }
            }
            if (!queue.isEmpty()) result++;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return result;
    }
}
