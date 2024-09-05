import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq=[]
        for i in range(len(nums)):
            heapq.heappush(pq,nums[i])

            if len(pq)>k:
                heapq.heappop(pq)
        return pq[0]
        