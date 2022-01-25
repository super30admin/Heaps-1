import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        heapq._heapify_max(nums)
        # print(list(nums))
        for i in range(k):
            heapq.heapify(nums)
            heapq._heapify_max(nums)
            ele = heapq.heappop(nums)
        return ele