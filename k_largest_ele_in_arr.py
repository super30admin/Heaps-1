# import heapq
# from typing import ist
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # by default heaps are min heaps
        heap = []

        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]


# time complexity is O(nlogk) where n is size of nums
# space complexity is O(k) where k is size of the heap
