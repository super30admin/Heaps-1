#Time Complexity: O(nlogk)
#Space Complexity: O(k)
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            heapq.heappush(heap,num)
            if (len(heap)>k):
                heapq.heappop(heap)
        min_peek = heap[0]
        return min_peek