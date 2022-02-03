# Time Complexity: O(nk Log nk)
# Space Complexity: O(1)
import heapq

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums = [-1* num for num in nums]
        heapq.heapify(nums)
        while k>1:
            heapq.heappop(nums)
            k -= 1
        return -1* nums[0]