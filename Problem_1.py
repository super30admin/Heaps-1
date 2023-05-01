# TC : O(NlogN)
# SC : O(N)

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        t = None
        j = len(nums) - k
        for i in range(0, j + 1):
            t = heapq.heappop(nums)
        return t