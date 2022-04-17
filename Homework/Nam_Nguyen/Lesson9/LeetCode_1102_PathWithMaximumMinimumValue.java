package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_1102_PathWithMaximumMinimumValue {

    boolean[][] visited;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int m, n;
    int maxValue = -1;
    int minValue = Integer.MAX_VALUE;

    public int maximumMinimumPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        findMaxMin(grid);
        int result = 0;

        while(minValue <= maxValue) {
            int mid = minValue + (maxValue-minValue)/2;
            if(grid[0][0] >= mid) {
                reset();
                DFS(0, 0, mid, grid);
                if(visited[m-1][n-1]) {
                    minValue = mid + 1;
                    result = mid;
                }else{
                    maxValue = mid - 1;
                }
            } else {
                maxValue = mid - 1;
            }
            
        }
        return result;
    }

    public void DFS(int x, int y, int value, int[][] grid) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n 
            && !visited[newX][newY] && grid[newX][newY] >= value) {
                DFS(newX, newY, value, grid);
            }
        }
    }

    public void findMaxMin(int[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                }
                if(grid[i][j] < minValue) {
                    minValue = grid[i][j];
                }
            }
        }
    }

    public void reset() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {5,4,5},
            {1,2,6},
            {7,4,6}
        };
        // int[][] grid = {
        //     {0,1,0,0,0,1},
        //     {0,1,1,0,0,0},
        //     {0,0,1,1,0,1},
        //     {0,1,1,1,1,0},
        //     {1,1,1,1,1,1}
        // };
        LeetCode_1102_PathWithMaximumMinimumValue n = new LeetCode_1102_PathWithMaximumMinimumValue();
        System.out.println("res: "+ n.maximumMinimumPath(grid));
    }
    
}
