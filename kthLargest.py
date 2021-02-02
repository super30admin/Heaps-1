# Time Complexity:    O(n.logk)
# Space Complexity:   O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if not nums  or len(nums) == 0:
            return -1
    
        minHeap = []
        
        # push into heap 
        for num in nums:
            heappush(minHeap, num)
        # check for it    
        while len(minHeap) > k:
            heappop(minHeap)
            
        return minHeap[0]
