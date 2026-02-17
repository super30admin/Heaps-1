# // Time Complexity : O(n log k)
# // Space Complexity : O(k)
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for i in nums:
            heapq.heappush(heap,i)

            if(len(heap)>k):
                heapq.heappop(heap)
        return heapq.heappop(heap)
