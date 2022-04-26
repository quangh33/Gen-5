namespace LeetCodeSolutions
{
    public class RottingOranges
    {
        private Queue<string> unrottenQueue = new Queue<string>();
        private int numRottenAMin = 0;
        private int colLen = 0;
        private int rowLen = 0;
        private int numFreshOrgane = 0;

        private int[][] directions = new int[][] {
            new int[]{0,1},
            new int[]{1,0},
            new int[]{0,-1},
            new int[]{-1,0}
        };

        public int OrangesRotting(int[][] grid)
        {
            int mins = 0;
            int visitTimes = 0;
            colLen = grid[0].Length;
            rowLen = grid.Length;
            FindRottenThenCheckUnrottenExist(grid);
            if (numFreshOrgane == 0) return 0;
            if (unrottenQueue.Count == 0) return -1;

            while (unrottenQueue.Count != 0)
            {
                visitTimes++;
                var nextOrange = unrottenQueue.Dequeue();
                int[] arr = nextOrange.Split(" ").Select(int.Parse).ToArray();
                int row = arr[0];
                int col = arr[1];
                GetAdjacent(grid, row, col);
                if (visitTimes == numRottenAMin)
                {
                    mins++;
                    numRottenAMin += unrottenQueue.Count;
                }
            }

            if (numFreshOrgane != 0) return -1;

            return mins - 1;
        }

        private void GetAdjacent(int[][] grid, int row, int col)
        {
            foreach (int[] direction in directions)
            {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow >= 0 && nextRow < rowLen && nextCol >= 0 && nextCol < colLen)
                {
                    if (grid[nextRow][nextCol] == 1)
                    {
                        numFreshOrgane--;
                        unrottenQueue.Enqueue($"{nextRow} {nextCol}");
                    }
                    grid[nextRow][nextCol] = 2;
                }
            }
        }

        private void FindRottenThenCheckUnrottenExist(int[][] grid)
        {
            for (int i = 0; i < rowLen; i++)
            {
                for (int j = 0; j < colLen; j++)
                {
                    if (grid[i][j] == 2)
                    {
                        unrottenQueue.Enqueue($"{i} {j}");
                        numRottenAMin++;
                    }
                    if (grid[i][j] == 1)
                    {
                        numFreshOrgane++;
                    }
                }
            }
        }
    }
}
