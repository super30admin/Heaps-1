# Time complexity: O(n logk) N - number of elements and k is the kth largest element value
# Space complexity: O(K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Using minHeap
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #base case
        if not nums  or len(nums) == 0:
            return -1
        
        topK = []
        
        # iterate and push into minheap 
        for i in range(len(nums)):
            heappush(topK, nums[i])
            if len(topK) > k: # if len of minheap(topK) is > than k than pop it from my minheap
                heappop(topK)
        
        return topK[0]
        
