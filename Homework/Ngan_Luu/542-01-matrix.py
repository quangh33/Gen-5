# 542. https://leetcode.com/problems/01-matrix/
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue=[]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
        adj_x=[ 0, 0,-1, 1]
        adj_y=[-1, 1, 0, 0]
        while queue:
            x=queue[0][0]
            y=queue[0][1]
            d=mat[x][y]
            queue.pop(0)
            for i in range(4):
                new_x=x+adj_x[i]
                new_y=y+adj_y[i]
                if 0<= new_x and new_x<len(mat) and 0<=new_y and new_y <len(mat[0]) and mat[new_x][new_y]==-1:
                    mat[new_x][new_y]=d+1
                    queue.append([new_x,new_y])
        return mat