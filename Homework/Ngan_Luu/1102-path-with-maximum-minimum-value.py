# https://leetcode.com/problems/path-with-maximum-minimum-value/
def isPath(grid,candidate):
    
    m=len(grid)
    n=len(grid[0])
    adj_x=[0,0,1,-1]
    adj_y=[-1,1,0,0]
    def dfs(x,y):
        grid[x][y]=-1
        for i in range(len(adj_y)):
            new_x=x+adj_x[i]
            new_y=y+adj_y[i]
            if new_x < m and new_x >=0 and new_y <n and new_y>=0 and grid[new_x][new_y]>=candidate:
                dfs(new_x,new_y)
    dfs(0,0)
    if grid[m-1][n-1]==-1:
        return True
    else:
        return False
        
class Solution:
    def maximumMinimumPath(self, grid: List[List[int]]) -> int:
        self.grid=grid
        m=len(grid)
        n=len(grid[0])
        maxPossibleScore=min(grid[0][0], grid[m-1][n-1])
        low=0
        high=maxPossibleScore
        res=0
        while low<=high:
            candidate=(high+low)//2
            new_grid=copy.deepcopy(grid)
            if isPath(new_grid,candidate):
                res=candidate
                low=candidate+1
            else:
                high=candidate-1
        return res