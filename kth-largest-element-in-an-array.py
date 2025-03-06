# Time Complexity : O(nlogk) - n is the len(nums)
# Space Complexity : O(k) - for heap
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Use min heap of size (k+1)
"""
import heapq


class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        heap = []
        for num in nums:
            heapq.heappush(heap,num)
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]