#Time Complexity: O(NlogK).
#Auxiliary Space: O(K)
#Did this code successfully run on Leetcode :Yes

import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        r = []
        for ele in nums:
            heapq.heappush(r,ele)
            if len(r)>k:
                heapq.heappop(r)
        return r[0]