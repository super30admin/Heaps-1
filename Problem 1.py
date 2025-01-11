class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for n in nums:
            heapq.heappush(heap, n)
            k-=1

            if k < 0:
                heapq.heappop(heap)
                k = 0
        return heapq.heappop(heap)
