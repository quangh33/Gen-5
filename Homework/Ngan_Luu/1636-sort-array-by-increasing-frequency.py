https://leetcode.com/.../sort-array-by-increasing-frequency/
class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        count={}
        for number in nums:
            if number in count:
                count[number].append(number)
            else:
                count[number]=[number]
        count_in_list=[None]*201
        for key,value in reversed(sorted(count.items())):
            if count_in_list[len(value)] is None:
                count_in_list[len(value)]=value
            else:
                count_in_list[len(value)]=count_in_list[len(value)]+value
        output=[]
        for fre in count_in_list:
            if fre is not None:
                output+=fre
        return output