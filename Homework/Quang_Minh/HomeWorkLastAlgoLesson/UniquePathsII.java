package HomeWorkLastAlgoLesson;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] state = new int[width];
        state[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    state[j] = 0;
                else if (j > 0)
                    state[j] += state[j - 1];
            }
        }
        return state[width - 1];
    }
}
