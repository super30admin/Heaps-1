
"""
// Time Complexity : o(nlogk)
// Space Complexity : o(1) constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = [] #maintain minheap
        
        for n in nums:
            heapq.heappush(heap, n)
            if len(heap) > k: #if k is exceeded, remove the min element
                heapq.heappop(heap)
                
        return heapq.heappop(heap) #at the end value at root will be kth largest value