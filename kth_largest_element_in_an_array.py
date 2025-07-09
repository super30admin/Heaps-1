# Time Complexity : O(n log k), where n is the number of elements in the array
# Space Complexity : O(k), for storing the heap of size k
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a min-heap to maintain the k largest elements seen so far.
# I pushed each element into the heap and popped the smallest when the heap exceeded size k.
# At the end, the root of the heap was the kth largest element.

import heapq
from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []

        for num in nums:
            heapq.heappush(min_heap, num)
            if len(min_heap) > k:
                heapq.heappop(min_heap)

        return min_heap[0]
