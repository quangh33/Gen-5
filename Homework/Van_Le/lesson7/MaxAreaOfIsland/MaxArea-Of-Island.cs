namespace LeetCodeSolutions
{
    public class MaxArea_Of_Island
    {
        int[][] grid;
        bool[,] seen;

        public int MaxAreaOfIsland(int[][] grid)
        {
            this.grid = grid;
            seen = new bool[grid.Length, grid[0].Length];
            int ans = 0;
            for (int r = 0; r < grid.Length; r++)
            {
                for (int c = 0; c < grid[0].Length; c++)
                {
                    ans = Math.Max(ans, Area(r, c));
                }
            }
            return ans;
        }

        public int Area(int r, int c)
        {
            if (r < 0
               || r >= grid.Length
               || c < 0
               || c >= grid[0].Length
               || seen[r, c]
               || grid[r][c] == 0)
                return 0;
            seen[r, c] = true;
            return (1 + Area(r + 1, c) + Area(r - 1, c) + Area(r, c + 1) + Area(r, c - 1));
        }
    }
}
