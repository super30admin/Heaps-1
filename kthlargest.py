# Time Complexity : O(NlogK)
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


from heapq import heappush,heappop
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
    
        n = len(nums)
        heap = []
        for i in range(k):
            heappush(heap, nums[i])
        for i in range(k,n):
            if nums[i] > heap[0]:
                heappop(heap)
                heappush(heap,nums[i])
        
        return heappop(heap)
            
        