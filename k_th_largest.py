# Time Complexity : O(n*logk) where n is the max elements in list and k is the number of list
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I add each element into min heap with size k. Everytime the size exceeds K we remove one element. At the end I remove
# One more element which is the kth largest

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for n in nums:
            heapq.heappush(heap, n)
            if len(heap) > k:
                heapq.heappop(heap)      
        return heapq.heappop(heap)