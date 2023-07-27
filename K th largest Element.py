# Time Complexity : O(n)
# Space Complexity : O(k)

# The code ran on LeetCode

# Maintain a min heap of size k. Add elements to the heap when size of heap is less than k. When size of heap is greater than k, pop the minimum element from the heap. After iteration, the top of the heap will contain the k th largest element

from heapq import heappush, heappop, heapify
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        heap = []; size = 0
        def add(heap, val):
            nonlocal size
            heappush(heap, val)
            size += 1
            if size > k:
                heappop(heap)
                size-=1
        for n in nums:
            add(heap, n)
        print(heap)
        return heap[0]

        