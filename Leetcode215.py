# Time Complexity: O(N log k) 
# Space Complexity: O(k)
import heapq
class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        min_heap = []
        heapq.heapify(min_heap)
        for num in nums:
            heapq.heappush(min_heap, num)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        return min_heap[0]  # The root of the min-heap (Kth largest element)