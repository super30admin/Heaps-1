"""
TC: O(n)
SP: O(k) only stores k elements
"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for n in nums:
            heapq.heappush(heap, n)
            if len(heap)>k:
                heapq.heappop(heap)
        return heapq.heappop(heap)

        
