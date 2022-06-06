package Homework.Nam_Nguyen.Lesson16;

public class LeetCode_63_UniquePathsII {
 
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i-1][0];
            if(obstacleGrid[i][0] == 1) f[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i-1];
            if(obstacleGrid[0][i] == 1) f[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
                if(obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                }    
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        LeetCode_63_UniquePathsII prob = new LeetCode_63_UniquePathsII();
        int[][] obstacleGrid = {{0,1,0},{1,1,0},{0,0,0}};
        System.out.println("res: "+prob.uniquePathsWithObstacles(obstacleGrid));
    }
}
