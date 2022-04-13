namespace LeetCodeSolutions
{
    public class _01Matrix
    {
        public int[][] UpdateMatrix(int[][] mat)
        {
            var list = new List<(int, int)>();
            var directions = new int[][] { new int[2] { 0, 1 }, new int[2] { 0, -1 }, new int[2] { 1, 0 }, new int[2] { -1, 0 } };
            for (var r = 0; r < mat.Length; r++)
            {
                for (var c = 0; c < mat[0].Length; c++)
                {
                    if (mat[r][c] == 0) list.Add((r, c));
                    else mat[r][c] = -1;
                }
            }

            var step = 1;
            while (list.Count > 0)
            {
                var newList = new List<(int, int)>();
                foreach (var (r, c) in list)
                {
                    foreach (var d in directions)
                    {
                        var newR = r + d[0];
                        var newC = c + d[1];
                        if (newR >= 0 && newR < mat.Length && newC >= 0 && newC < mat[0].Length && mat[newR][newC] == -1)
                        {
                            newList.Add((newR, newC));
                            mat[newR][newC] = step;
                        }
                    }
                }
                list = newList;
                step++;
            }

            return mat;
        }
    }
}
