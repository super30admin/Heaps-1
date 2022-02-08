# Time  Complexity o(nlog(k)) where k is the kth largest element to be found.
# This is beacuse the array contains n elements and at every element we have to heapify until k 
# Space complexity
# We can solve this by using max heap and min heap

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        
        heap = []
        
        heapq.heapify(heap)
        
        
        for a in nums:
            
            heapq.heappush(heap,a)
            
            if len(heap) >k:
                heapq.heappop(heap)
        
        return heap[0]