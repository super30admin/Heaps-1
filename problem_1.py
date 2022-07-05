# Time Complexity : O(n*log(k))
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# Using minHeap
# TC: O(n*log(k)); SC: O(k)
import heapq


class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        heap = []
        for i in nums:
            heapq.heappush(heap, i)
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]


print(Solution().findKthLargest([3, 2, 3, 1, 2, 4, 5, 5, 6], 4))

# Using maxHeap
# import heapq
# import sys
#
#
# class Solution:
#     def findKthLargest(self, nums: list[int], k: int) -> int:
#         heap = []
#         min = -sys.maxsize
#         for i in nums:
#             heapq.heappush(heap, -i)
#             if len(heap) > len(nums)-k:
#                 min = max(min, heapq.heappop(heap))
#         return -1 * min
#
#
# print(Solution().findKthLargest([3, 2, 3, 1, 2, 4, 5, 5, 6], 4))


# O(n*log(n))
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         nums.sort()
#         for i in range(k):
#             max = nums.pop()
#         return max
#
#
# print(Solution().findKthLargest([3, 2, 1, 5, 6, 4], 2))
