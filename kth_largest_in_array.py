#time Complexity = (nlog(k))
import heapq 
class Solution(object):
    def findKthLargest(self, nums, k):
        
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        h = []
        for i in nums:
            heapq.heappush(h,i)
            if len(h)>k:
                heapq.heappop(h)
        return heapq.heappop(h)