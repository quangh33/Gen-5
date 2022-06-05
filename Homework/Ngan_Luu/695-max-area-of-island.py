# 695. https://leetcode.com/problems/max-area-of-island
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n_rows,n_cols=len(grid),len(grid[0])
        adj_x = [-1,1, 0,0]
        adj_y = [ 0,0,-1,1]
        self.area=0
        maximum=0
        def dfs(x,y):
            if  grid[x][y]==1:
                self.area+=1
                grid[x][y]=0
                for i in range(4):
                    new_x=x+adj_x[i]
                    new_y=y+adj_y[i]
                    if 0<=new_x and new_x< n_rows and 0<=new_y and new_y < n_cols:
                        dfs(new_x,new_y)
            else:
                return 0
        for x in range(n_rows):
            for y in range(n_cols):
                dfs(x,y)
                maximum=max(maximum,self.area)
                self.area=0
        return maximum