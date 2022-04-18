/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function (grid) {
  const n = grid.length;
  const dr = [-1, -1, -1, 0, 1, 1, 1, 0];
  const dc = [-1, 0, 1, 1, 1, 0, -1, -1];

  const queue = [];

  const visited = [];
  for (let i = 0; i < n; i++) {
    visited.push([]);
  }
  if (!grid[0][0]) {
    queue.unshift([0, 0]);
  }

  let currentStep = 0;

  while (queue.length) {
    currentStep++;
    const currentSize = queue.length;

    for (let i = 0; i < currentSize; i++) {
      const [r, c] = queue.pop();
      if (r === n - 1 && c === n - 1) {
        return currentStep;
      }

      for (let j = 0; j < 8; j++) {
        const newR = r + dr[j];
        const newC = c + dc[j];

        if (
          newR >= 0 &&
          newR < n &&
          newC >= 0 &&
          newC < n &&
          !visited[newR][newC] &&
          !grid[newR][newC]
        ) {
          visited[newR][newC] = true;
          queue.unshift([newR, newC]);
        }
      }
    }
  }

  return -1;
};
