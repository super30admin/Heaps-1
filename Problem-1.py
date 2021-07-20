"""
Approach: using min heap
1) Maintain a min heap of length k, iterate through all the elements and push them into the heap
2) since we are using min heap, the top of the heap would have the kth largest element
TC: O(n log k)
SC: O(k)

"""

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        priorityq = []
        heapq.heapify(priorityq)
        for num in nums:
            heapq.heappush(priorityq, num)
            if len(priorityq) > k:
                heapq.heappop(priorityq)
        return heapq.heappop(priorityq)