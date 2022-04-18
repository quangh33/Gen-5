/**
 * @param {number[][]} grid
 * @return {number}
 */

 const getLandArea = (r, c, grid, visited) => {
    // top = [r - 1, c]
    // left = [r, c - 1]
    // right = [r, c + 1]
    // bottom = [r + 1, c]
    if (grid[r] === undefined || grid[r][c] === undefined) return 0
    if (visited[r][c]) return 0
    if (grid[r][c] === 0) return 0
    visited[r][c] = true
    return 1 + getLandArea(r - 1, c, grid, visited) + getLandArea(r, c - 1, grid, visited)
    + getLandArea(r, c + 1, grid, visited) + getLandArea(r + 1, c, grid, visited)
    
}

var maxAreaOfIsland = function(grid) {
    let maxLandArea = 0
    let visited = new Array(grid.length).fill(null)
    visited.forEach((r,i) => {
        visited[i] = new Array(grid[0].length).fill(false)
    })
    for (let r = 0; r < grid.length;r++) {
        for (let c = 0; c < grid[0].length; c++) {
            if (grid[r][c] === 1) {
                const newLandArea = getLandArea(r, c, grid, visited)
                maxLandArea = Math.max(maxLandArea, newLandArea)
            }
        }
    }
    return maxLandArea
};
