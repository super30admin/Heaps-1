# Time Complexity:- O(n logk)
# Space Complexity:- O(n)
# Approach:- Using inbuilt library which gurantees O(nlogk) performance

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]