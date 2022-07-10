"""
TC/SC: O(Nlogk)/O(K)
"""

from Queue import PriorityQueue
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        q = PriorityQueue()
        for num in nums:
            q.put(num)
            if q.qsize() > k:
                q.get()
        return q.get()
