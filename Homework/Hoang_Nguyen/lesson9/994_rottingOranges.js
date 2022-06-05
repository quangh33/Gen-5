/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function (grid) {
  const m = grid.length;
  const n = grid[0].length;

  const visited = [];
  for (let i = 0; i < m; i++) {
    visited.push([]);
  }

  let freshNum = 0;
  const queue = [];

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === 2) {
        queue.unshift([i, j]);
        visited[i][j] = true;
      } else if (grid[i][j] === 1) {
        freshNum++;
      }
    }
  }

  if (freshNum === 0) return 0;

  let minutes = -1;

  const dr = [1, 0, -1, 0];
  const dc = [0, 1, 0, -1];

  while (queue.length) {
    minutes++;
    const currentSize = queue.length;
    for (let i = 0; i < currentSize; i++) {
      const [r, c] = queue.pop();

      for (let j = 0; j < 4; j++) {
        const newR = r + dr[j];
        const newC = c + dc[j];

        if (
          newR >= 0 &&
          newR < m &&
          newC >= 0 &&
          newC < n &&
          !visited[newR][newC] &&
          grid[newR][newC] === 1
        ) {
          queue.unshift([newR, newC]);
          visited[newR][newC] = true;
          freshNum--;
          if (freshNum === 0) return minutes + 1;
        }
      }
    }
  }

  return -1;
};
