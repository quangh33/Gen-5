from queue import PriorityQueue
from typing import List

INF = 100000001

class Dijkstra:
    def __init__(self, times: List[List[int]], n: int, k: int) -> None:
        '''
            n: number of node
            k: start node
        '''
        self.queue = PriorityQueue()
        self.n2n = [[INF] * n for _ in range(n)]
        for time in times:
            source, target, weight = time
            self.n2n[source - 1][target - 1] = weight
            # self.n2n[target - 1][source - 1] = weight
           
        self.distances = [INF] * n
        self.distances[k-1] = 0
        self.queue.put((0, k))

    def calculateDistances(self) -> List[int]:
        while not self.queue.empty():
            baseDistance, source = self.queue.get()
            for target, addDistance in enumerate(self.n2n[source-1]):
                newDistance = baseDistance + addDistance
                if newDistance < self.distances[target]:
                    self.distances[target] = newDistance
                    self.queue.put((newDistance, target + 1))
        return self.distances

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        d = Dijkstra(times, n, k)
        distances = d.calculateDistances()
        result = max(distances)
        if result == INF:
            result = -1
        return result

s = Solution()
times = [
    [1, 2, 4],
    [1, 6, 2],
    [2, 3, 5],
    [2, 6, 1],
    [3, 4, 6],
    [3, 5, 2],
    [3, 6, 8],
    [4, 5, 5],
    [5, 6, 10]
]

# print(s.networkDelayTime(times, 6, 1) == 15)
# times = [[2,1,1],[2,3,1],[3,4,1]]
# print(s.networkDelayTime(times, 4, 2) == 2)
# times = [[1,2,1]]
# print(s.networkDelayTime(times, 2, 1) == 1)
# times = [[1,2,1]]
# print(s.networkDelayTime(times, 2, 2) == -1)
times = [[3,5,78],[2,1,1],[1,3,0],[4,3,59],[5,3,85],[5,2,22],[2,4,23],[1,4,43],[4,5,75],[5,1,15],[1,5,91],[4,1,16],[3,2,98],[3,4,22],[5,4,31],[1,2,0],[2,5,4],[4,2,51],[3,1,36],[2,3,59]]
d = Dijkstra(times, 5, 5)
print(d.calculateDistances())
# print(s.networkDelayTime(times, 5, 5) == 31)


