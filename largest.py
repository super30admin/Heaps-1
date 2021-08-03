import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # nums.sort()
        # return nums[len(nums)-k]
        res=[]
        for i in range(len(nums)):
            heapq.heappush(res,nums[i])
            if len(res)>k:
                heapq.heappop(res)
        return heapq.heappop(res)
    
   