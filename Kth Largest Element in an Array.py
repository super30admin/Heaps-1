# Time Complexity :  O(Nlogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        li = []
        for i in nums:
            heapq.heappush(li,i)
            if len(li) > k:
                heapq.heappop(li)
        return heapq.heappop(li)

        

            