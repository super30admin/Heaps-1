# // Time Complexity :O(nlogk)
# // Space Complexity :O(k),elements in the heap
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

from heapq import heappush as insert
from heapq import heappop as remove
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        minheap=[]
        for i in range(len(nums)):
            insert(minheap,nums[i])
            # print(minheap)
            if len(minheap)>k:
                remove(minheap)
        return minheap[0]
            
            
        