package HomeWorkLesson9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PairWithMaximumMinimumValue {
    private class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maximumMinimumPath(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0, 0));
        int[][] score = new int[height][width];
        int[] stepX = {0, -1, 1, 0};
        int[] stepY = {-1, 0, 0, 1};
        score[0][0] = grid[0][0];
        while (!q.isEmpty()) {
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                Position currentPosition = q.poll();
                int currentX = currentPosition.x;
                int currentY = currentPosition.y;
                for (int j = 0; j < 4; j++) {
                    int nextX = currentX + stepX[j];
                    int nextY = currentY + stepY[j];
                    if (nextX >= 0 && nextX < height && nextY >= 0 && nextY < width) {
                        int scoreNextPos = Math.min(score[currentX][currentY], grid[nextX][nextY]);
                        if (scoreNextPos > score[nextX][nextY]) {
                            score[nextX][nextY] = scoreNextPos;
                            q.add(new Position(nextX, nextY));
                        }
                    }
                }
            }
        }
        return score[height - 1][width - 1];
    }
}
