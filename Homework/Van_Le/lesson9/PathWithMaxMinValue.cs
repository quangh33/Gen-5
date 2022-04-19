namespace LeetCodeSolutions
{
    public class PathWithMaxMinValue
    {
        private int colLen = 0;
        private int rowLen = 0;

        private int[][] directions = new int[][] {
            new int[]{0,1},
            new int[]{1,0},
            new int[]{0,-1},
            new int[]{-1,0}
        };

        public int MaximumMinimumPath(int[][] grid)
        {
            colLen = grid[0].Length;
            rowLen = grid.Length;



            int left = 0, right = Math.Min(grid[0][0], grid[rowLen - 1][colLen - 1]);

            while (left < right)
            {
                var visited = new bool[rowLen, colLen];
                int middle = (right + left + 1) / 2;

                if (PathExists(grid, middle, visited, 0, 0))
                {
                    left = middle;
                }
                else
                {
                    right = middle - 1;
                }
            }

            return left;
        }

        private bool PathExists(int[][] grid, int value, bool[,] visited, int curRow, int curCol)
        {
            if (curRow == rowLen - 1 && curCol == colLen - 1) return true;

            visited[curRow, curCol] = true;
            foreach (int[] direction in directions)
            {
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];

                if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen
                    && !visited[newRow, newCol] && grid[newRow][newCol] >= value)
                {
                    if (PathExists(grid, value, visited, newRow, newCol))
                        return true;
                }
            }
            return false;
        }
    }
}
