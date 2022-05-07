https://leetcode.com/problems/rotting-oranges/
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue=[]
        time=[]
        if all([1 not in a for a in grid]):
            return 0
        if all([2 not in a for a in grid]):
            return -1
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    queue.append([i,j])
                    time.append(0)
        while queue:
            x=queue[0][0]
            y=queue[0][1]
            mins=time[0]
            queue.pop(0)
            time.pop(0)
            for adj_x,adj_y in [(0,-1),(0,1),(-1,0),(1,0)]:
                new_x=x+adj_x
                new_y=y+adj_y
                if 0<=new_x and new_x <len(grid) and 0<=new_y and new_y<len(grid[0]) and grid[new_x][new_y]==1:
                    queue.append([new_x,new_y])
                    time.append(mins+1)
                    grid[new_x][new_y]=2
        print(grid)
        if any([1 in a for a in grid]):
            return -1
        return mins