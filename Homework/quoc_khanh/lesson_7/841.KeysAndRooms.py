from typing import List


class Solution:
    def visit(self, rooms: List[List[int]], visited: List[bool], index: int) -> int:
        count = 0
        if not visited[index]:
            count += 1
            visited[index] = True
            keys = rooms[index]
            for key in keys:
                count += self.visit(rooms, visited, key)
        return count

    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        length = len(rooms)
        visited = [False] * length
        if self.visit(rooms, visited, 0) == length:
            return True
        return False

s = Solution()
print(s.canVisitAllRooms([[1],[2],[3],[]]) == True)
print(s.canVisitAllRooms([[1,3],[3,0,1],[2],[0]]) == False)