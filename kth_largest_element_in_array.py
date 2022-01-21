# Approach
# Maintain a heap of size k
# Popping once after processing the entire list should yield res

# TC: O(N log k)
# SC: O(k)

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in nums:
            heapq.heappush(heap, i)
            if len(heap) > k:
                heapq.heappop(heap)
        res = (heapq.heappop(heap))
        return res


import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]