""""// Time Complexity : O(n.log(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

from heapq import heappush, heappop
import sys


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h = []
        mini = -sys.maxsize
        n = len(nums)
        count = 0
        for num in nums:
            heapq.heappush(h, -num)
            count += 1

            if count > n - k:
                x = heapq.heappop(h)
                mini = max(mini, x)
        return -1 * mini

#         #   edge case
#         if (nums == None or len(nums) == 0):
#             return -1

#         #   initialize an empty list which acts as min heap
#         topK= []
#         count=0

#         for x in nums:
#             heapq.heappush(topK, x)
#             count+=1

#             if count>k:
#                 heapq.heappop(topK)
#                 count-=1
#         return topK[0]


