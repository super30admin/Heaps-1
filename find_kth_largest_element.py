# Time Complexity : O(N log K) where N is number of elements given
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq as hq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        ktop = []
        ktop.append(nums[0])
        hq.heapify(ktop)
        
        for i in range(1, len(nums)):
            if len(ktop) == k:
                if ktop[0] < nums[i]:
                    hq.heappop(ktop)
                    hq.heappush(ktop, nums[i])
            else:
                hq.heappush(ktop, nums[i])
                
        return ktop[0]