class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for x in nums:
            heapq.heappush(heap,-x)
        for i in range(k-1):
            heapq.heappop(heap)
        return -heapq.heappop(heap)
