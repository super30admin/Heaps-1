# Time Complexity : O(nlogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
from heapq import heappush, heappushpop, heappop

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hp = []
        for n in nums:
            if len(hp) < k:
                heappush(hp, n)
            else:
                heappushpop(hp, n)
            
        return heappop(hp)