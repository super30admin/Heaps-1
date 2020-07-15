# Time Complexity :average O(nlogk)
# Space Complexity :O(k)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #create heap
        helper = []
        # for each number in input
        for i in nums:
            #push to heap
            heapq.heappush(helper,i)
            # if length is greater than k make it k again
            if len(helper) > k:
                heapq.heappop(helper)
        # return top of heap
        return heapq.heappop(helper)
        