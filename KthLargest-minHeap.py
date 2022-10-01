#Time: O(logn)
#Space: O(n)
#Program ran on leetcode successfully

from heapq import heappush as insert
from heapq import heappop as remove

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pq = []
        for num in nums:
            heapq.heappush(pq, num)
            if (len(pq) > k):
                heapq.heappop(pq)
        
        return heapq.heappop(pq)
        
        