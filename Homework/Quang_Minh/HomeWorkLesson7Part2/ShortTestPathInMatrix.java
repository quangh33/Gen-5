package HomeWorkLesson7Part2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortTestPathInMatrix {
    private class Position {
        int x;
        int y;
        int distance;

        Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.distance = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        if (grid[0][0] == 1) return -1;
        int width = grid[0].length;
        int height = grid.length;
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0, 0, 1));
        int[] stepX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] stepY = {-1, 0, 1, -1, 1, -1, 0, 1};
        boolean[][] visited = new boolean[height][width];
        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();
            if (currentPosition.x == width - 1 && currentPosition.y == height - 1) return currentPosition.distance;
            for (int i = 0; i < 8; i++) {
                int nextX = currentPosition.x + stepX[i];
                int nextY = currentPosition.y + stepY[i];
                if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < height &&
                        !visited[nextY][nextX] && grid[nextY][nextX] == 0) {
                    visited[nextY][nextX] = true;
                    queue.add(new Position(nextX, nextY, currentPosition.distance + 1));
                }
            }
        }
        return -1;
    }

}
