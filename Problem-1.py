
# 215. Kth Largest Element in an Array

# Code:
#  Learning heaps : In order to achieve the max heap technique: did a -i for every element in the array.
import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # In python heaps are always min-heap!!!!
        
        nums = [-i for i in nums]
        res = []
        
        for i in nums:
            heapq.heappush(res, i)
        
        
        while res and k>1:
            k-=1
            heapq.heappop(res)
        
        return -heapq.heappop(res)




# Time Complexity: O(nlogn)
# Space Complexity: O(1)
# Accepted on Leetcode: Yes.