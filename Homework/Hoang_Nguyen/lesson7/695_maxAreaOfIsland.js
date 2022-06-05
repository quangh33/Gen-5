/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function (grid) {
  const m = grid.length;
  const n = grid[0].length;

  const visited = [];
  for (let i = 0; i < m; i++) {
    visited.push([]);
  }

  const dr = [0, 1, 0, -1];
  const dc = [1, 0, -1, 0];

  let maxArea = 0;
  let currentArea = 0;

  function visit(r, c) {
    visited[r][c] = true;

    currentArea++;
    if (currentArea > maxArea) {
      maxArea = currentArea;
    }

    for (let i = 0; i < 4; i++) {
      const r1 = r + dr[i];
      const c1 = c + dc[i];
      if (
        r1 >= 0 &&
        r1 < m &&
        c1 >= 0 &&
        c1 < n &&
        !visited[r1][c1] &&
        grid[r1][c1]
      ) {
        visit(r1, c1);
      }
    }
  }

  for (let r = 0; r < m; r++) {
    for (let c = 0; c < n; c++) {
      if (!visited[r][c] && grid[r][c]) {
        currentArea = 0;
        visit(r, c);
      }
    }
  }
  return maxArea;
};
