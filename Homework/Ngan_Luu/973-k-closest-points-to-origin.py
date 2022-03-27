https://leetcode.com/problems/k-closest-points-to-origin
def calDistanceOrigin(point):
    return sqrt(point[0]**2+point[1]**2)
def quickSelect_key(points,left,right,k): #ascending
    p=left
    for i in range(left,right):
        if calDistanceOrigin(points[i])<=calDistanceOrigin(points[right]):
            points[i],points[p]=points[p],points[i]
            p+=1
    points[p],points[right]=points[right],points[p]
    if p==k:
        return points[:k+1]
    if k<p:
        return quickSelect_key(points,left,p-1,k)
    if k>p:
        return quickSelect_key(points,p+1,right,k)
    
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        k=k-1 
        return quickSelect_key(points,0,len(points)-1,k)