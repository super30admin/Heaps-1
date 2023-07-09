# Time Complexity : O(Nlogk) 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
# Approach is to heapify the k elements and .

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        q=nums
        heapq.heapify(q)
        n1=len(nums)
        n=len(nums)
        while(n1>k):
            heapq.heappop(q)
            n1-=1
        return heapq.heappop(q)