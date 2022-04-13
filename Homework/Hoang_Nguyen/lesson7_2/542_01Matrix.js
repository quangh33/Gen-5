/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var updateMatrix = function (mat) {
  const m = mat.length;
  const n = mat[0].length;

  const dr = [1, 0, -1, 0];
  const dc = [0, 1, 0, -1];

  const queue = [];

  const dis = [];
  for (let i = 0; i < m; i++) {
    dis.push([]);
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (mat[i][j] === 0) {
        dis[i][j] = 0;
        queue.unshift([i, j]);
      }
    }
  }

  let currentDis = 0;
  while (queue.length) {
    currentDis++;
    const currentSize = queue.length;
    for (let i = 0; i < currentSize; i++) {
      const [r, c] = queue.pop();

      for (let j = 0; j < 8; j++) {
        const newR = r + dr[j];
        const newC = c + dc[j];
        if (
          newR >= 0 &&
          newR < m &&
          newC >= 0 &&
          newC < n &&
          mat[newR][newC] === 1 &&
          dis[newR][newC] === undefined
        ) {
          dis[newR][newC] = currentDis;
          queue.unshift([newR, newC]);
        }
      }
    }
  }
  return dis;
};
