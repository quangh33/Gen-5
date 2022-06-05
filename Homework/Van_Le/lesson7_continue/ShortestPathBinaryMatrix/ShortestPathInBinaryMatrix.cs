namespace LeetCodeSolutions
{
    public class ShortestPathInBinaryMatrix
    {
        private int[] direction1 = { -1, -1 };
        private int[] direction2 = { -1, 0 };
        private int[] direction3 = { -1, 1 };
        private int[] direction4 = { 0, -1 };
        private int[] direction5 = { 0, 1 };
        private int[] direction6 = { 1, -1 };
        private int[] direction7 = { 1, 0 };
        private int[] direction8 = { 1, 1 };

        private static int[][] directions = new int[8][];

        public ShortestPathInBinaryMatrix()
        {
            directions[0] = direction1;
            directions[1] = direction2;
            directions[2] = direction3;
            directions[3] = direction4;
            directions[4] = direction5;
            directions[4] = direction5;
            directions[5] = direction6;
            directions[6] = direction7;
            directions[7] = direction8;
        }

        public int ShortestPathBinaryMatrix(int[][] grid)
        {
            if (grid[0][0] != 0 || grid[grid.Length - 1][grid[0].Length - 1] != 0)
            {
                return -1;
            }

            Queue<int[]> queue = new Queue<int[]>();
            grid[0][0] = 1;
            queue.Enqueue(new int[] { 0, 0 });

            // Carry out the BFS
            while (queue.Count != 0)
            {
                int[] cell = queue.Dequeue();
                int row = cell[0];
                int col = cell[1];
                int distance = grid[row][col];
                if (row == grid.Length - 1 && col == grid[0].Length - 1)
                {
                    return distance;
                }
                foreach (int[] neighbour in GetNeighbours(row, col, grid))
                {
                    int neighbourRow = neighbour[0];
                    int neighbourCol = neighbour[1];
                    queue.Enqueue(new int[] { neighbourRow, neighbourCol });
                    grid[neighbourRow][neighbourCol] = distance + 1;
                }
            }

            // The target was unreachable.
            return -1;
        }

        private List<int[]> GetNeighbours(int row, int col, int[][] grid)
        {
            List<int[]> neighbours = new List<int[]>();
            for (int i = 0; i < directions.Length; i++)
            {
                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];
                if (newRow < 0 || newCol < 0 || newRow >= grid.Length
                        || newCol >= grid[0].Length
                        || grid[newRow][newCol] != 0)
                {
                    continue;
                }
                neighbours.Add(new int[] { newRow, newCol });
            }
            return neighbours;
        }
    }
}
