import heapq
from heapq import heapify


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # maiking an array of elements of -ve and +ve elements of the same elements
        nums = [(-num, num) for num in nums]
        # heapify will sort the nums list to [(-6, 6), (-5, 5), (-4, 4), (-3, 3), (-2, 2), (-1, 1)]
        heapify(nums)

        for i in range(k - 1):
            heapq.heappop(nums)  # (-6, 6) popped
        # remaining element will be [-5, 5), (-4, 4), (-3, 3), (-2, 2), (-1, 1)] and will return 5
        return heapq.heappop(nums)[1]
