#kth largest
# // Time Complexity : O(N Log K)
# // Space Complexity : O(K)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


import heapq

class Solution:
    def findKthLargest(self, nums, k: int) -> int:
        res=[]
        for i in nums:
            heapq.heappush(res, i)              #push the element into the meanheap
            if(len(res)>k):                     #is the minheap gets bigger than the k, then you know you can get rid of the smallest one
                heapq.heappop(res)
        return res[0]                           #return the least number out of the remaining numbers