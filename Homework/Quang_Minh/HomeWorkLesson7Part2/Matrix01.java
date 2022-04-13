package HomeWorkLesson7Part2;

import javafx.geometry.Pos;

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix01 {
    private class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int[] stepX = {0, -1, 1, 0};
        int[] stepY = {-1, 0, 0, 1};
        int height = mat.length;
        int width = mat[0].length;
        Queue<Position> queue = new ArrayDeque<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) queue.offer(new Position(i, j));
                else mat[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPosition.x + stepX[i];
                int nextY = currentPosition.y + stepY[i];
                if (nextX >= 0 && nextX < height && nextY >= 0 && nextY < width && mat[nextX][nextY] == -1) {
                    queue.offer(new Position(nextX, nextY));
                    mat[nextX][nextY] = mat[currentPosition.x][currentPosition.y] + 1;
                }
            }
        }
        return mat;
    }
}