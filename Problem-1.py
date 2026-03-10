# Time Complexity : O(N log k), N = length of nums
# Space Complexity : O(k), heap stores at most k elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# We use a min-heap of size k to keep track of the k largest elements.
# Iterate through the numbers:
#   - If the heap has less than k elements, push the number.
#   - Else, if the current number is bigger than the smallest in heap,
#     replace the smallest with the current number.
# After processing all numbers, the heap contains the k largest elements,
# and the smallest in the heap is the kth largest element.

import heapq
from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []
        for num in nums:
            if len(min_heap) < k:
                heapq.heappush(min_heap, num)
            else:
                if num > min_heap[0]:
                    heapq.heappushpop(min_heap, num)
        return min_heap[0]

# Example usage:
# nums = [3,2,1,5,6,4]
# k = 2
# obj = Solution()
# print(obj.findKthLargest(nums, k))  # Output: 5