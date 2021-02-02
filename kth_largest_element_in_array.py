import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = nums[:k]
        heapq.heapify(heap)
        for num in nums[k:]:
            minelement = heap[0]
            if minelement<num:
                heapq.heappop(heap)
                heapq.heappush(heap,num)
        return heap[0]