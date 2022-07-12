'''
Time Complexity: O(nlog(k))
Space Complexity: O(k)
Run on Leetcode: YES
'''
import heapq

class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        minHeap = []
        for num in nums:
            heapq.heappush(minHeap, num)
            if len(minHeap) > k:
                heapq.heappop(minHeap)

        return heapq.heappop(minHeap) 