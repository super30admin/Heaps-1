# Heap
# TC: O(Nlogk)
# SC: O(k)
# Yes, It ran on leetcode.
# Problems: No, already solved it earlier

import heapq
class Solution:
    def findKthLargest(self, nums,k: int) -> int:
        Heap = []
        for i in nums:
            heapq.heappush(Heap, i)
        length = len(nums)-k
        while length>0:
            length -= 1
            heapq.heappop(Heap)
        return heapq.heappop(Heap)
            