import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        queue = []
        for i in nums:
            heapq.heappush(queue,i)
            if(len(queue)==k+1):
                heapq.heappop(queue)
    
        return heapq.heappop(queue)