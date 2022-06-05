/**
 * @param {number[][]} grid
 * @return {number}
 */
var maximumMinimumPath = function (grid) {
  const m = grid.length;
  const n = grid[0].length;

  let low = 10 ** 10;
  let high = -1;

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      const val = grid[i][j];
      low = Math.min(low, val);
      high = Math.max(high, val);
    }
  }

  let ans;

  while (low <= high) {
    const mid = low + Math.floor((high - low) / 2);
    if (canFoundPath(mid)) {
      ans = mid;
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return ans;

  function canFoundPath(minVal) {
    if (grid[0][0] < minVal) {
      return false;
    }
    const dr = [1, 0, -1, 0];
    const dc = [0, 1, 0, -1];

    const queue = [[0, 0]];
    const visited = [];
    for (let i = 0; i < m; i++) {
      visited.push([]);
    }

    while (queue.length) {
      const currentSize = queue.length;
      for (let i = 0; i < currentSize; i++) {
        const [r, c] = queue.pop();

        if (r === m - 1 && c === n - 1) {
          return true;
        }

        visited[r][c] = true;

        for (let j = 0; j < 4; j++) {
          const newR = r + dr[j];
          const newC = c + dc[j];
          if (
            newR >= 0 &&
            newR < m &&
            newC >= 0 &&
            newC < n &&
            !visited[newR][newC] &&
            grid[newR][newC] >= minVal
          ) {
            queue.push([newR, newC]);
          }
        }
      }
    }
    return false;
  }
};
