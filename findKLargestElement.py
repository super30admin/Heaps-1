import heapq
class Solution:
    # min heap
    # TC : O(nlogk)
    # SC : O(k)
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if nums is None:
            return 0
        heap = []
        for num in nums:
            if len(heap) < k:
                heapq.heappush(heap,num)
            else:
                heapq.heappushpop(heap,num)
        return heap[0]