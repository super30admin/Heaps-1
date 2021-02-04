#Time Complexity :O(nlogk) 
#Space Complexity :o(k) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if(nums==None or len(nums)==0):
            return -1
        h=[]
        
        for i in nums:
            heapq.heappush(h,i)
            if(len(h)>k):
                heapq.heappop(h)
        
        return heapq.heappop(h)
                