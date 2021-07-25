# Time Complexity : O(n)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#using min heap to keep track fo kth largest element in an array
from heapq import heappush as insert
from heapq import heappop as poll
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        heap = []
        
        for i in nums:
            insert(heap,i)
            if len(heap) > k:
                poll(heap)
                
        return poll(heap)
        
            
            
            
        