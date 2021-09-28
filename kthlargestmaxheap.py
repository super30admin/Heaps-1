# // Time Complexity :O(nlog(n-k))
# // Space Complexity :O(n-k),elements in the heap
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
from heapq import heappush as insert
from heapq import heappop as remove
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        maxheap=[]
        for i in range(len(nums)):
            insert(maxheap,(-nums[i]))
            # print(maxheap)
            if (len(maxheap)-1)>(len(nums)-k):
                remove(maxheap)
        # print(maxheap)
            
        return -(maxheap[0])
        
        