# 841. https://leetcode.com/problems/keys-and-rooms/
class Solution:                
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited=[None]*len(rooms)
        def dfs(curr):
            visited[curr]=True
            print(curr)
            for i in rooms[curr]:
                if not(visited[i]):
                    dfs(i)
        dfs(0)
        return all(visited)