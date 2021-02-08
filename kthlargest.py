# -*- coding: utf-8 -*-
"""
TC:O(Nlogk) where N is the size of the arrys and k is the kth largest element
SC:O(k) for Priority Queue
"""
import heapq

class Solution:
    def findKthLargest(self, nums:[], k:int) :
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #Base case
        if not nums  or len(nums) == 0:
            return -1
        
        topK = []
        
        # Iterate and push into minheap 
        for i in range(len(nums)):
            heapq.heappush(topK, nums[i])
			# if len of minheap(topK) is > than k than pop it from my minheap
            if len(topK) > k:
                heapq.heappop(topK)
        
		#return 0th element in topK which holds the kth largest element
        return topK[0]
    
S = Solution()
print(S.findKthLargest([3,2,1,5,6,4],3))