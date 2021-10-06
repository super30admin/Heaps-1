"""
https://leetcode.com/problems/kth-largest-element-in-an-array/
:return
Approach: We take a min heap and put all the elemnts inside the heap and check anytime if the length of the heap is
greater than 2, we should pop fro the heap, so everytime we pop the smallest element and the two elements remaining inside the heap
are largest one's the top one would be kth largest element.
Tc: O(nlogk)
Sc: O(n)
"""

import heapq

class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        heapq.heapify(heap)
        # for i in range(len(heap)):
        for i in range(len(nums)):
            heapq.heappush(heap, nums[i])
            if len(heap) > k:
                heapq.heappop(heap)
        return heapq.heappop(heap)



