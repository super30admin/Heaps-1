# Time Complexity : O(Nlogk)
# Space Complexity : O(k) space used to store the heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Min Heap. We iterate through all the N elements in the list so that takes O(N).
# We build the min heap of size K and add K elements to the heap. The adding operation takes O(logK).
# If the heap is greater than k then pop the minimum elements from the heap
# Then return the root element of the heap

import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0
        heap = []
        for i in range(len(nums)):
            heapq.heappush(heap, nums[i])
            if len(heap) > k:
                heapq.heappop(heap)
        return heapq.heappop(heap)