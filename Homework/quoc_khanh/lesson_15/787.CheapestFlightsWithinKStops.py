import collections
import heapq
from itertools import count
from queue import PriorityQueue
from typing import List

INF = 123456789123

class Dijkstra:
    def __init__(self, n: int, flights: List[List[int]], src: int) -> None:
        '''
            n: number of nodes
            k: number of maximum stop
        '''
        self.queue = PriorityQueue()
        self.n2n = [[INF] * n for _ in range(n)]
        for time in flights:
            source, target, price = time
            self.n2n[source][target] = price
        self.queue.put((0, src, 0))

    def calculateDistance(self, dest: int, k: int) -> List[int]:
        seen = {} # time limit error on python
        while not self.queue.empty():
            basePrice, source, stopCount = self.queue.get()
            if source == dest:
                return basePrice

            if source in seen and seen[source] < stopCount:
                continue
            seen[source] = stopCount

            if stopCount <= k:
                for currDestIdx, addPrice in enumerate(self.n2n[source]):
                    if addPrice != INF:
                        newPrice = basePrice + addPrice
                        self.queue.put((newPrice, currDestIdx, stopCount + 1))

        return -1

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        d = Dijkstra(n, flights, src)
        return d.calculateDistance(dst, k)

s = Solution()
flights = [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
print(s.findCheapestPrice(4, flights, 0, 3, 1) == 6)

flights = [[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
print(s.findCheapestPrice(5, flights, 0, 2, 2))

flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
print(s.findCheapestPrice(4, flights, 0, 3, 1) == 700)
print(s.findCheapestPrice(4, flights, 0, 3, 2) == 400)
print(s.findCheapestPrice(4, flights, 0, 3, 0) == -1)
flights = [[0,1,100],[1,2,100],[0,2,500]]
print(s.findCheapestPrice(3, flights, 0, 2, 1) == 200)
print(s.findCheapestPrice(3, flights, 0, 2, 0) == 500)
flights = [[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]
print(s.findCheapestPrice(10, flights, 6, 0, 7) == 14)
flights = [[11,12,74],[1,8,91],[4,6,13],[7,6,39],[5,12,8],[0,12,54],[8,4,32],[0,11,4],[4,0,91],[11,7,64],[6,3,88],[8,5,80],[11,10,91],[10,0,60],[8,7,92],[12,6,78],[6,2,8],[4,3,54],[3,11,76],[3,12,23],[11,6,79],[6,12,36],[2,11,100],[2,5,49],[7,0,17],[5,8,95],[3,9,98],[8,10,61],[2,12,38],[5,7,58],[9,4,37],[8,6,79],[9,0,1],[2,3,12],[7,10,7],[12,10,52],[7,2,68],[12,2,100],[6,9,53],[7,4,90],[0,5,43],[11,2,52],[11,8,50],[12,4,38],[7,9,94],[2,7,38],[3,7,88],[9,12,20],[12,0,26],[10,5,38],[12,8,50],[0,2,77],[11,0,13],[9,10,76],[2,6,67],[5,6,34],[9,7,62],[5,3,67]]
print(s.findCheapestPrice(13, flights, 10, 1, 10))