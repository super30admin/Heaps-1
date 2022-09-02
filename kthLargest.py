
# // Time Complexity : O(N Log K)
# // Space Complexity : O(K)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


import heapq

class Solution:
    def findKthLargest(self, nums, k: int) -> int:
        res=[]
        for i in nums:
            heapq.heappush(res, i)              
            if(len(res)>k):                     
                heapq.heappop(res)
        return res[0] 