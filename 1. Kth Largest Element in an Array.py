# Using a heap
import heapq
class Solution:
    # Time Complexity - O(nlogk)
    # Space Complexity - O(k)
    def findKthLargest(self, nums, k: int) -> int:
        largest = []
        for value in nums:
            if (len(largest) < k):
                heapq.heappush(largest, value)
            else:
                heapq.heappushpop(largest, value)
        if (len(largest) < k):
            return None
        return largest[0]