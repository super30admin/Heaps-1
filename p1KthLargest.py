"""
time: avg: O(N), worst: O(N^2)
space:O(1)
using Quick Select Algo

"""

import heapq
class Solution:

    def findKthLargest(self, nums, k):
        k = len(nums) - k
        def quickSelect(l, r):
            pivot, p = nums[r], l
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[p], nums[i] = nums[i], nums[p]
                    p += 1
            nums[p], nums[r] = pivot,nums[p]

            if p > k: return quickSelect(l, p-1)
            elif p < k: return  quickSelect(p+1,r)
            else: return nums[p]

        return quickSelect(0, len(nums)-1)



    """
    time: O(NlogN)
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapify(nums)
        
        for _ in range(len(nums)-k):
            heapq.heappop(nums)
        return heapq.heappop(nums)

    """"