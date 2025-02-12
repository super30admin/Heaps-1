class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if nums is None and len(nums) == 0:
            return 0
        n = len(nums)
        pq = []
        for i in range(n):
            num = nums[i]
            heapq.heappush(pq, num)
            if len(pq) > k:
                heapq.heappop(pq)
        return heapq.heappop(pq)