class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i=m-1
        j=n-1
        for k in range(len(nums1)-1,-1,-1):
            if j==-1:
                break
            if i==-1:
                nums1[k]=nums2[j]
                j-=1
            else:
                if nums1[i]<=nums2[j]:
                    nums1[k]=nums2[j]
                    j-=1
                else:
                    nums1[k]=nums1[i]
                    i-=1
