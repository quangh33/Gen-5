# 1091. https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n=len(grid)
        if grid[0][0]==1 or grid[n-1][n-1]==1:
            return -1
        queue=[[0,0]]
        grid[0][0]=1
        adj_x=[-1,0,1,-1,1,-1, 0, 1]
        adj_y=[ 1,1,1, 0,0,-1,-1,-1]
        while queue:
            x=queue[0][0]
            y=queue[0][1]
            d=grid[x][y]
            queue.pop(0)
            for i in range(8):
                new_x=x+adj_x[i]
                new_y=y+adj_y[i]
                if new_x<n and new_x>=0 and new_y <n and new_y >=0:
                    if grid[new_x][new_y]==0:
                        queue.append([new_x,new_y])
                        grid[new_x][new_y]=d+1
        if grid[n-1][n-1]==0:
            return -1
        else:
            return grid[n-1][n-1]