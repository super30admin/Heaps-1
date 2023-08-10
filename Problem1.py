#Time Complexity :O(nlogk)
#Space Complexity :O(k)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap=[] #minheap by deafult
        for i in range(len(nums)): #O(n)
            heapq.heappush(heap,nums[i]) #O(logk)
            if len(heap)>k: #O(1)
                heapq.heappop(heap) #O(logk)
        return heap[0] #O(1) 