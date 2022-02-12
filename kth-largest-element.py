# Time Complexity : O(nlogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]

# Another approach


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        result = []  # to store heap elements

        for i in nums:
            # if the size is greater than the k size then pop the top element
            if len(result) == k:
                heapq.heappushpop(result, i)

            else:
                heapq.heappush(result, i)

        return heapq.heappop(result)
